package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Subscription
import com.tothenew.linksharing.Topic
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
			subscription1.seriousness = Seriousness.convertToEnum(seriousness)
			if (subscription1.save(flush: true)) {
				render([message: "Subscription information updated"] as JSON)
			} else {
				render([error: "Error updating subscription information!!"] as JSON)
			}
		} else {
			render([error: "Subscription not found!"] as JSON)
		}

	}

	def delete(Long subscriptionId) {
		Subscription subscription = Subscription.get(subscriptionId)
		if (subscription) {
			//render " $subscription"
			if (session.user == subscription.topic.createdBy) {
				render([error: "Can not unsubscribe a topic created by you"] as JSON)
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
