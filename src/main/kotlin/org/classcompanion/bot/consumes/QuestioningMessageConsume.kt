package org.classcompanion.bot.consumes

import com.rabbitmq.client.Delivery
import net.dv8tion.jda.api.entities.TextChannel
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.rabbitmq.OnConsume
import java.nio.charset.Charset

class QuestioningMessageConsume(private val channel: TextChannel): OnConsume {
	override fun execute(delivery: Delivery, charset: Charset) {
		println(String(delivery.body, charset))
		channel.sendMessageEmbeds(EmbedUtils.datesEmbed(String(delivery.body, charset))).queue()
	}
}