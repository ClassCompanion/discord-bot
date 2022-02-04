package org.classcompanion.bot

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.utils.ChunkingFilter
import org.classcompanion.bot.commands.PingCommand
import org.classcompanion.bot.managers.SlashCommandManager


class Bot(token: String, Guild: String) {
	// Managers
	/*var messagesManager: MessagesManager? = MessagesManager()*/
	var slashCommandManager: SlashCommandManager? = SlashCommandManager()
	init {
		val builder: JDABuilder = JDABuilder.createDefault(token)
		builder.setActivity(Activity.playing("with schoolbooks"))
		builder.setChunkingFilter(ChunkingFilter.ALL)
		builder.addEventListeners(/*messagesManager, */slashCommandManager)

		val jda = builder.build()
		jda.awaitReady()

		jda.updateCommands().addCommands(
			Commands.slash("ping", "ping")
		)

		slashCommandManager?.registerCommand("ping", PingCommand())
	}
}

