package org.classcompanion.bot.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import org.classcompanion.bot.objects.SlashCommand

class PingCommand : SlashCommand {
	override fun executeCommand(event: SlashCommandInteractionEvent?) {
		event?.deferReply(false)?.queue()
		val interactionHook = event?.hook
		interactionHook?.sendMessage("pong")?.queue()
	}

}