package org.classcompanion.bot.consumes

import com.rabbitmq.client.Delivery
import net.dv8tion.jda.api.entities.TextChannel
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.rabbitmq.OnConsume
import java.nio.charset.Charset

class ToMessageConsume(private val channel: TextChannel): OnConsume {
	override fun execute(delivery: Delivery, charset: Charset) {
		println(String(delivery.body, charset))
		println(channel)
		channel.sendMessageEmbeds(EmbedUtils.basicImageEmbed(
			"Message from server",
			"body",
			String(delivery.body, charset),
			"https://www.kindpng.com/picc/m/122-1224817_pogchamp-png-transparent-png.png")).queue()
	}
}