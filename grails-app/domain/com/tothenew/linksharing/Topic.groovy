package com.tothenew.linksharing


class Topic {
	String topicName
	User createdBy
	Date dateCreated
	Date lastUpdated

	Visibility visibility

	static hasMany = [resources: Resource, subscriptions: Subscription]

	static constraints = {
		topicName blank: false, nullable: false, unique: 'createdBy'
		createdBy nullable: false

	}

	String toString() {
		"Topic --> ${topicName}"
	}

	def afterInsert() {
		Topic.withNewSession {
			Subscription subscription = new Subscription(user: this.createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS).save()

			log.info("${this.createdBy.name} subscribed to ${this.topicName}")

		}


	}
	static mapping = {
		sort("topicName")
	}

}

