package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness


class Subscription {

    Date dateCreated
    Date lastUpdated

	Seriousness seriousness = Seriousness.SERIOUS

    static belongsTo = [user: User, topic: Topic]
    static constraints = {
        topic nullable: false, unique: 'user'
        user nullable: false


    }

	static mapping = {
		user lazy: false
		topic lazy: false
	}
	String toString() {
		"$user subscribed to $topic"
	}
}
