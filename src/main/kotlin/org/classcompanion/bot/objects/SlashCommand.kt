package org.classcompanion.bot.objects

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent


interface SlashCommand {
	fun executeCommand(event: SlashCommandInteractionEvent?)
}