package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness
import grails.converters.JSON

class SubscriptionController {

	def save(Long topicId) {

		Subscription subscription = new Subscription(topic: Topic.get(topicId), user: session.user, seriousness: Seriousness.SERIOUS)
		if (subscription.save(flush: true))
			render([message: "Subscription saved successfully"] as JSON)
		else {
			render([error: "Error saving subscription!!"] as JSON)
		}
	}

	def update(Long id, String seriousness) {
		Subscription subscription1 = Subscription.get(id)
		if (subscription1) {
			if (seriousness == "Very Serious")
				seriousness = "Very_Serious"
			subscription1.seriousness = Seriousness.getSeriousness(seriousness)
			if (subscription1.save(flush: true)) {
				render([message: "Subscription information updated"] as JSON)
			} else {
				render([error: "Error updating subscription information!!"] as JSON)
			}
		} else {
			render([error: "Subscription not found!"] as JSON)
		}
	}

	def delete(Long topicId) {
		Subscription subscription = Subscription.findByUserAndTopic(session.user, Topic.get(topicId))
		if (subscription) {
			if (session.user == subscription.topic.createdBy) {
				render([error: "Sorry, you can not unusbscribe a self-created a topic"] as JSON)
			} else {
				try {
					subscription.delete(flush: true)
					render([message: "$subscription deleted successfully"] as JSON)
				}
				catch (Exception e) {
					log.error "Error: ${e.message}"
					render([error: "could not delete $subscription"] as JSON)
				}
			}
		} else {
			render([error: "Subscription not found!!"] as JSON)
		}
	}
}
