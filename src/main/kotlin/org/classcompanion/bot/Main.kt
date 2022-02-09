package org.classcompanion.bot

import io.github.cdimascio.dotenv.Dotenv

fun main(args: Array<String>) {
	val dotenv: Dotenv = Dotenv.load()
	val token = dotenv["TOKEN"]
	val guild = dotenv["GUILD"]
	val rabbitMqIP = dotenv["RABBITMQ-IP"]
	Bot(token!!, guild!!, rabbitMqIP!!)
}