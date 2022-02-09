package org.classcompanion.bot.commands

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.internal.utils.PermissionUtil
import org.classcompanion.bot.objects.SlashCommand
import org.classcompanion.bot.utils.EmbedUtils
import org.classcompanion.botlib.BotLib
import java.awt.Color

class SetTextChannelCommand(private val bot: BotLib) : SlashCommand {
	override fun executeCommand(event: SlashCommandInteractionEvent?) {
		event?.deferReply(false)?.queue()
		val member = event!!.member
		val interactionHook = event.hook
		if (PermissionUtil.checkPermission(member, Permission.ADMINISTRATOR)) {
			try {
				bot.sendMessage("""{"messageType": "setdefaultchannel", "newDefaultChannel": "${event.channel}"}""")
				interactionHook.sendMessageEmbeds(EmbedUtils.basicTextEmbed("Success", "Default chat set successfully!", "", color = Color.GREEN))
					.queue()
			} catch (e: Error) {
				interactionHook.sendMessageEmbeds(EmbedUtils.basicTextEmbed("Failed", "Error", e.toString(), color = Color.RED))
					.queue()
			}
		} else {
			interactionHook.sendMessageEmbeds(EmbedUtils.basicTextEmbed("Failed", "Insufficient permissions:", "ADMINISTRATOR", color = Color.RED))
				.queue()
		}
	}
}