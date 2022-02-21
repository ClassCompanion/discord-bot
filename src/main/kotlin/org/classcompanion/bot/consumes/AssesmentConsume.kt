package org.classcompanion.bot.consumes

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rabbitmq.client.Delivery
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Message
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.BotLib
import org.classcompanion.botlib.objects.Assesment
import org.classcompanion.botlib.rabbitmq.OnConsume
import java.nio.charset.Charset
import java.util.function.Consumer

class AssesmentConsume(private val bot: BotLib, private val jda: JDA, private val channel: String): OnConsume {
	override fun execute(delivery: Delivery, charset: Charset) {
		val mapper = jacksonObjectMapper()
		val q: Assesment = mapper.readValue(String(delivery.body, charset))
		if (q.messageId == null) {
			jda.getTextChannelById(channel)?.sendMessageEmbeds(/* embed = */ EmbedUtils.datesEmbed(q))
				?.queue(Consumer { message: Message ->
					val messageId = message.idLong
					bot.sendMessageId(messageId, q.id)
				})
		} else {
			println(q.messageId)
			jda.getTextChannelById(channel)?.editMessageEmbedsById(q.messageId, EmbedUtils.datesEmbed(q))?.queue()
		}
	}
}