package org.classcompanion.bot.managers

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class MessagesManager : ListenerAdapter() {
	override fun onMessageReceived(event: MessageReceivedEvent) {
		val quotationMark = '"'
		val message = event.message.contentRaw
		val startCommand = message.split(quotationMark.toString()).toTypedArray()
		val selectCommand = message.split(" ".toRegex()).toTypedArray()
		if (selectCommand[0].equals("!ping", ignoreCase = true)) {
			event.channel.sendMessage("pong")
		}
	}
}