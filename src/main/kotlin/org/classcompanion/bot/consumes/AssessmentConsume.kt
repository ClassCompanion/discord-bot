package org.classcompanion.bot.consumes

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.rabbitmq.client.Delivery
import net.dv8tion.jda.api.JDA
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.BotLib
import org.classcompanion.botlib.objects.Assessment
import org.classcompanion.botlib.rabbitmq.OnConsume
import java.nio.charset.Charset

class AssessmentConsume(private val bot: BotLib, private val jda: JDA, private val channel: String) : OnConsume {
    override fun execute(delivery: Delivery, charset: Charset) {
        println(String(delivery.body, charset))
        val mapper = jacksonObjectMapper()
        val q: Assessment = mapper.readValue<Assessment>(String(delivery.body, charset), Assessment::class.java)
        println(q.title)
        if (q.message_id == null) {
            jda.getTextChannelById(channel)?.sendMessageEmbeds(EmbedUtils.datesEmbed(q))
                ?.queue()
        } else {
            println(q.message_id)
            jda.getTextChannelById(channel)?.editMessageEmbedsById(q.message_id!!, EmbedUtils.datesEmbed(q))?.queue()
        }
    }
}