package org.classcompanion.bot.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import org.classcompanion.bot.objects.SlashCommand
import org.classcompanion.bot.utils.EmbedUtils

class PingCommand : SlashCommand {
	override fun executeCommand(event: SlashCommandInteractionEvent?) {
		event?.deferReply(false)?.queue()
		val interactionHook = event?.hook
		interactionHook?.sendMessageEmbeds(EmbedUtils.basicTextEmbed("PONG", "pond", "I pong'd"))?.queue()
	}
}