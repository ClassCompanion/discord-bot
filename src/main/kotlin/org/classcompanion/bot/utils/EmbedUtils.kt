package org.classcompanion.bot.utils

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color
import java.lang.String

object EmbedUtils {
	/*fun quoteCreatedSuccessfully(): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle("Quote uspešno ustvarjen")
		embed.setColor(Color.GREEN)
		return embed.build()
	}

	fun noPerm(): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle("NAPAKA")
		embed.setColor(Color.RED)
		embed.addField("Nimaš dovoljenja za uporabo komande.", "za uporabo moraš biti quoter.", false)
		return embed.build()
	}

	fun quotes(quotes: ArrayList<Quote?>): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setColor(Color.GREEN)
		for (q in quotes) {
			embed.addField(q.getQuote(), "-" + q.getAuthor().getAsMention().toString() + " " + q.getYear(), false)
		}
		return embed.build()
	}

	fun noQuotes(): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle("Ta uporabnik še nima quotov :confused:")
		embed.setColor(Color.LIGHT_GRAY)
		return embed.build()
	}

	fun userStatistic(statistic: Statistic): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle("Statistika uporabnika")
		embed.setColor(Color.LIGHT_GRAY)
		embed.addField("Število quotov:", String.valueOf(statistic.getAllQuotes()), true)
		embed.addField("Odstotek vseh quotov:", statistic.getPercentage() + "%", true)
		return embed.build()
	}

	fun quoteStats(): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle("Statistika quotov")
		embed.setColor(Color.LIGHT_GRAY)
		embed.addField("Število quotov:", String.valueOf(MongoUtils.countAllQuotes()), true)
		return embed.build()
	}

	fun iDontWantTo(): MessageEmbed {
		val embed = EmbedBuilder()
		embed.setTitle("Nečem")
		embed.setColor(Color.RED)
		embed.addField("Nemrem", "Ne bom. Uporabi slash komando.", true)
		return embed.build()
	}*/
}