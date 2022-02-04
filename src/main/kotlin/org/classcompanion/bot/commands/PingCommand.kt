package org.classcompanion.bot.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import org.classcompanion.bot.objects.SlashCommand
import org.classcompanion.bot.utils.EmbedUtils

class PingCommand : SlashCommand {
	override fun executeCommand(event: SlashCommandInteractionEvent?) {
		event?.deferReply(false)?.queue()
		val interactionHook = event?.hook
		interactionHook?.sendMessageEmbeds(EmbedUtils.basicImageEmbed("PONG", "pong", "I pong'd", "https://www.kindpng.com/picc/m/122-1224817_pogchamp-png-transparent-png.png"))?.queue()
	}
}