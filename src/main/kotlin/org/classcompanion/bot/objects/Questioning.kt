package org.classcompanion.bot.objects

data class Questioning(
	val questioning: String,
	val dates: HashMap<String, Array<Long>>,
	val messageId: String,
	val channel: String
	)
