package org.classcompanion.bot

import io.github.cdimascio.dotenv.Dotenv

fun main(args: Array<String>) {
	val dotenv: Dotenv = Dotenv.load()
	/*val token = System.getenv("TOKEN")
	val guild = System.getenv("GUILD")
	val rabbitMqIP = System.getenv("RABBITMQ-IP")
	Bot(token!!, guild!!, rabbitMqIP!!, System.getenv("CHANNEL")!!)*/

	val token = dotenv["TOKEN"]
	val guild = dotenv["GUILD"]
	val rabbitMqIP = dotenv["RABBITMQ-IP"]
	Bot(token!!, guild!!, rabbitMqIP!!, dotenv["CHANNEL"]!!)
}