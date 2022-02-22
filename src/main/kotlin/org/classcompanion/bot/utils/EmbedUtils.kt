package org.classcompanion.bot.utils

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import org.classcompanion.botlib.objects.Assessment
import java.awt.Color


object EmbedUtils {
    // build embeds , names are self-explaining

    fun basicTextEmbed(
        title: String,
        fieldName: String,
        fieldValue: String,
        inline: Boolean = true,
        color: Color = Color.GREEN
    ): MessageEmbed {
        val embed = EmbedBuilder()
        embed.setTitle(title)
        embed.setColor(color)
        embed.addField(fieldName, fieldValue, inline)
        embed.setThumbnail("https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
        embed.setFooter("ClassCompanion", "https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
        return embed.build()
    }

    fun basicImageEmbed(
        title: String,
        fieldName: String,
        fieldValue: String,
        imageUrl: String,
        inline: Boolean = true,
        color: Color = Color.GREEN
    ): MessageEmbed {
        val embed = EmbedBuilder()
        embed.setTitle(title)
        embed.setColor(color)
        embed.addField(fieldName, fieldValue, inline)
        embed.setImage(imageUrl)
        embed.setThumbnail("https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
        embed.setFooter("ClassCompanion", "https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
        return embed.build()
    }

    fun datesEmbed(q: Assessment, inline: Boolean = false, color: Color = Color.GREEN): MessageEmbed {
        val embed = EmbedBuilder()
        embed.setTitle(q.title)
        embed.setColor(color)
        for (term in q.terms) {
            var fieldvalue = ""
            for (userid in term.entries) {
                fieldvalue = if (fieldvalue == "") {
                    fieldvalue.plus("<@${userid.chat_id}>")
                } else {
                    fieldvalue.plus(", ").plus("<@${userid.chat_id}>")
                }
            }
            embed.addField(term.date, fieldvalue, inline)
        }
        embed.setThumbnail("https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
        embed.setFooter("ClassCompanion", "https://avatars.githubusercontent.com/u/98977989?s=200&v=4")
        return embed.build()
    }
}