package org.classcompanion.bot.consumes

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rabbitmq.client.Delivery
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.TextChannel
import org.classcompanion.bot.objects.Questioning
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.BotLib
import org.classcompanion.botlib.rabbitmq.OnConsume
import java.nio.charset.Charset
import java.util.function.Consumer

class MessageConsume(private val channel: TextChannel, private val bot: BotLib): OnConsume {
	override fun execute(delivery: Delivery, charset: Charset) {
		println(String(delivery.body, charset))
		val mapper = jacksonObjectMapper()
		val q: Questioning = mapper.readValue(String(delivery.body, charset))
		if (q.messageId == "") {
			channel.sendMessageEmbeds(/* embed = */ EmbedUtils.datesEmbed(q)).queue(Consumer { message: Message ->
				val messageId = message.idLong
				val msg = """{"messageType": "newQuestioningMessage", "messageId": "$messageId", "questioningName": "${q.questioning}"}"""
				println(msg)
				bot.sendMessage(msg)
			})
		} else {
			println(q.messageId)
			channel.editMessageEmbedsById(q.messageId, EmbedUtils.datesEmbed(q)).queue()
		}
	}
}