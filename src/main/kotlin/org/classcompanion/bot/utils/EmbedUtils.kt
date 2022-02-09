package org.classcompanion.bot.utils

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import org.classcompanion.bot.objects.Questioning
import java.awt.Color


object EmbedUtils {
	fun basicTextEmbed(title: String, fieldName: String, fieldValue: String, inline: Boolean = true, color: Color = Color.GREEN): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle(title)
		embed.setColor(color)
		embed.addField(fieldName, fieldValue, inline)
		embed.setThumbnail("https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
		embed.setFooter("ClassCompanion", "https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
		return embed.build()
	}
	fun basicImageEmbed(title: String, fieldName: String, fieldValue: String, imageUrl: String, inline: Boolean = true, color: Color = Color.GREEN): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle(title)
		embed.setColor(color)
		embed.addField(fieldName, fieldValue, inline)
		embed.setImage(imageUrl)
		embed.setThumbnail("https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
		embed.setFooter("ClassCompanion", "https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
		return embed.build()
	}
	fun datesEmbed(q: Questioning, inline: Boolean = false, color: Color = Color.GREEN): MessageEmbed {
		val embed = EmbedBuilder()

		embed.setTitle(q.questioning)
		embed.setColor(color)
		for ((datum, list) in q.dates) {
			var fieldvalue = ""
			for (userid in list) {
				fieldvalue = if (fieldvalue == "") {
					fieldvalue.plus("<@$userid>")
				} else {
					fieldvalue.plus(", ").plus("<@$userid>")
				}
			}
			embed.addField(datum, fieldvalue, inline)
		}
		embed.setThumbnail("https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
		embed.setFooter("ClassCompanion", "https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
		return embed.build()

	}
}