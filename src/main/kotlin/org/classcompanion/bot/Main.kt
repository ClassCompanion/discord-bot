package org.classcompanion.bot

import io.github.cdimascio.dotenv.Dotenv

fun main(args: Array<String>) {
	val dotenv: Dotenv = Dotenv.load()
	val token = dotenv["TOKEN"]
	val guild = dotenv["GUILD"]
	val rabbitmqip = dotenv["RABBITMQ-IP"]
	val bot: Bot = Bot(token!!, guild!!, rabbitmqip!!)
}