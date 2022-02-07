package org.classcompanion.bot.consumes

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.rabbitmq.client.Delivery
import net.dv8tion.jda.api.entities.TextChannel
import org.classcompanion.bot.objects.Questioning
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.rabbitmq.OnConsume
import java.nio.charset.Charset

class QuestioningMessageConsume(private val channel: TextChannel): OnConsume {
	override fun execute(delivery: Delivery, charset: Charset) {
		println(String(delivery.body, charset))
		val mapper = jacksonObjectMapper()
		val q: Questioning = mapper.readValue(String(delivery.body, charset))
		if (q.messageId == "") {
			channel.sendMessageEmbeds(EmbedUtils.datesEmbed(q)).queue()
		} else {
			println(q.messageId)
			channel.editMessageEmbedsById(q.messageId, EmbedUtils.datesEmbed(q)).queue()
		}
	}
}