package org.classcompanion.bot.consumes

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.rabbitmq.client.Delivery
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Message
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.BotLib
import org.classcompanion.botlib.objects.Assessment
import org.classcompanion.botlib.rabbitmq.OnConsume
import java.nio.charset.Charset
import java.util.function.Consumer

class AssessmentConsume(private val bot: BotLib, private val jda: JDA, private val channel: String) : OnConsume {
    override fun execute(delivery: Delivery, charset: Charset) {
        // map json to assessment objects
        println(String(delivery.body, charset))
        val mapper = jacksonObjectMapper()
        val assessment: Assessment = mapper.readValue<Assessment>(String(delivery.body, charset), Assessment::class.java)

        // if message_id is null, create new message and send new message_id back
        if (assessment.message_id == null) {
            jda.getTextChannelById(channel)?.sendMessageEmbeds(EmbedUtils.datesEmbed(assessment))
                ?.queue(Consumer { message: Message ->
                    val messageId = message.idLong
                    bot.sendMessageId(messageId, assessment.id)
                })
        } else {
            // edit embed in message with message_id
            jda.getTextChannelById(channel)?.editMessageEmbedsById(assessment.message_id!!, EmbedUtils.datesEmbed(assessment))?.queue()
        }
    }
}