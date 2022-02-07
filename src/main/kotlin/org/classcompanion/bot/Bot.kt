package org.classcompanion.bot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.utils.ChunkingFilter
import org.classcompanion.bot.commands.PingCommand
import org.classcompanion.bot.consumes.ToMessageConsume
import org.classcompanion.bot.managers.SlashCommandManager
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.BotLib



class Bot(token: String, guild: String, rabbitmqip: String) {
	// Managers
	/*var messagesManager: MessagesManager? = MessagesManager()*/
	private val slashCommandManager: SlashCommandManager = SlashCommandManager()
	val jda: JDA
	init {
		val builder: JDABuilder = JDABuilder.createDefault(token)
		builder.setActivity(Activity.playing("Portal 2: Education"))
		builder.setChunkingFilter(ChunkingFilter.ALL)
		builder.addEventListeners(/*messagesManager, */slashCommandManager)

		jda = builder.build()
		jda.awaitReady()

		jda.updateCommands().addCommands(
			Commands.slash("ping", "ping")
		)

		slashCommandManager.registerCommand("ping", PingCommand())

		val bot: BotLib = BotLib(rabbitmqip, guild)
		val defaultChannel: TextChannel? = jda.getTextChannelById(753495220888535080)
		bot.setConsume(ToMessageConsume(defaultChannel!!))
	}
}

