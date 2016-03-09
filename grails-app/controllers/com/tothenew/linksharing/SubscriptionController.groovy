package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Subscription
import com.tothenew.linksharing.Topic

class SubscriptionController {

	def save(Long topicId) {

		Subscription subscription = new Subscription(topic: Topic.get(topicId), user: session.user, seriousness: Seriousness.SERIOUS)
		if (subscription.save(flush: true))
			render "Subscription saved successfully"
		else {
			render("Error saving subscription!!")
		}
	}

	def update(Long id, String seriousness) {
		Subscription subscription1 = Subscription.get(id)
		if (subscription1) {
			subscription1.seriousness = Seriousness.convertToEnum(seriousness)
			if (subscription1.save(flush: true)) {
				render("Subscription information updated")
			} else {
				render("Error updating subscription information!!")
			}
		}else {
			render("Subscription not found!")
		}

	}

	def delete(Long subscriptionId) {
		Subscription subscription = Subscription.get(subscriptionId)
		if (subscription) {
			//render " $subscription"
			if (subscription.delete(flush: true))
				render "$subscription deleted successfully"
			else
				render("could not delete $subscription")
		} else {
			render "Subscription not found!!"
		}
	}
}
