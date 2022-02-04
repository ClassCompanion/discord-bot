package org.classcompanion.bot.managers

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.classcompanion.bot.objects.SlashCommand

class SlashCommandManager : ListenerAdapter() {
	override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
		commands[event.name]?.executeCommand(event)
	}

	fun registerCommand(name: String, command: SlashCommand) {
		commands[name] = command
	}

	companion object {
		private val commands: HashMap<String, SlashCommand> = HashMap<String, SlashCommand>()
	}
}