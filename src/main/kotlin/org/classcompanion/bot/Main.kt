package org.classcompanion.bot

import io.github.cdimascio.dotenv.Dotenv

fun main(args: Array<String>) {
	// for production, use ENV variables when running
	/*val token = System.getenv("TOKEN")
	val guild = System.getenv("GUILD")
	val rabbitMqIP = System.getenv("RABBITMQ-IP")
	val rabbitusername = System.getenv("RABBITMQ-USERNAME")
	val rabbitpassword = System.getenv("RABBITMQ-PASSWD")
	Bot(token!!, guild!!, rabbitMqIP!!, System.getenv("CHANNEL")!!)*/

	// for testing using a .env file
	val dotenv: Dotenv = Dotenv.load()
	val token = dotenv["TOKEN"]
	val guild = dotenv["GUILD"]
	val rabbitMqIP = dotenv["RABBITMQ-IP"]
	val rabbitusername = dotenv["RABBITMQ-USERNAME"]
	val rabbitpassword = dotenv["RABBITMQ-PASSWD"]
	Bot(token!!, guild!!, rabbitMqIP!!, rabbitusername!!, rabbitpassword!!, dotenv["CHANNEL"]!!)
}