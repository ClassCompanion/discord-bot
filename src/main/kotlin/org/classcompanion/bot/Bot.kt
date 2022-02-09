package org.classcompanion.bot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.utils.ChunkingFilter
import org.classcompanion.bot.commands.PingCommand
import org.classcompanion.bot.commands.SetTextChannelCommand
import org.classcompanion.bot.consumes.MessageConsume
import org.classcompanion.bot.managers.SlashCommandManager
import org.classcompanion.botlib.BotLib


class Bot(token: String, guild: String, rabbitMqIP: String) {
	private val slashCommandManager: SlashCommandManager = SlashCommandManager()
	private val jda: JDA
	init {
		val builder: JDABuilder = JDABuilder.createDefault(token)
		val bot = BotLib(rabbitMqIP, guild)
		builder.setActivity(Activity.playing("Portal 2: Education"))
		builder.setChunkingFilter(ChunkingFilter.ALL)
		builder.addEventListeners(/*messagesManager, */slashCommandManager)

		jda = builder.build()
		jda.awaitReady()

		jda.updateCommands().addCommands(
			Commands.slash("ping", "ping"),
			Commands.slash("setdefaultchannel", "Set the default text channel")
		)

		slashCommandManager.registerCommand("ping", PingCommand())
		slashCommandManager.registerCommand("setdefaultchannel", SetTextChannelCommand(bot))


		val defaultChannel: TextChannel? = jda.getTextChannelById(753495220888535080)
		bot.setConsume(MessageConsume(defaultChannel!!, bot))
		//bot.setConsume(ToMessageConsume(defaultChannel!!))
	}
}

