package org.classcompanion.bot

import io.github.cdimascio.dotenv.Dotenv

fun main(args: Array<String>) {
	var dotenv: Dotenv = Dotenv.load()
	val token = dotenv["TOKEN"]
	val guild = dotenv["GUILD"]
	val bot: Bot = Bot(token!!, guild!!)
}