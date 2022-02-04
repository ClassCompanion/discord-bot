package org.classcompanion.bot.utils

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color


object EmbedUtils {
	fun basicTextEmbed(title: String, fieldName: String, fieldValue: String, inline: Boolean = true, color: Color = Color.GREEN): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle(title)
		embed.setColor(color)
		embed.addField(fieldName, fieldValue, inline)
		return embed.build()
	}
	fun basicImageEmbed(title: String, fieldName: String, fieldValue: String, imageUrl: String, inline: Boolean = true, color: Color = Color.GREEN): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle(title)
		embed.setColor(color)
		embed.addField(fieldName, fieldValue, inline)
		embed.setImage(imageUrl)
		return embed.build()
	}
}