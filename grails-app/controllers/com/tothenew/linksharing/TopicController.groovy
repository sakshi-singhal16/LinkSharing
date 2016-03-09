package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import com.tothenew.linksharing.CO.TopicCO
import com.tothenew.linksharing.Enums.Visibility


class TopicController {
	def index(Long id) {
		Topic topic=Topic.get(id)
//		render("$topic")
		List<User> subscribedUsers=topic.getSubscribedUsers()
		render (view: 'index', model: [users:subscribedUsers, topicObj: topic])
	}

	def show(ResourceSearchCO co) {
		Topic topic = Topic.read(co.topicId)
		if (topic) {
			if (topic.visibility == Visibility.PUBLIC)
				render("Public topic.. Success")
			else {
				User user = session.user
				Subscription subscription = Subscription.findByTopicAndUser(topic, user)
				if (subscription)
					render("Private topic.. Success")
				else {
					redirect(controller: 'login', action: 'index')
					flash.message = "Private topic. Subscribe to view this topic"
				}
			}
		} else {
			redirect(controller: 'login', action: 'index')
			flash.message = "Topic not found"
		}

	}

	def save(TopicCO topicCO) {

		Topic topic = new Topic(topicName: topicCO.topicName, createdBy: session.user,
				visibility: Visibility.convertToEnum(topicCO.visibility))

		if (topic.save()) {
			flash.message = "$topic saved"
			render(flash.message)
		} else {
			log.error("Error saving $topic!!!!!!")
			flash.message = "Error saving $topic!!!!!!"
			//render("Error saving $topic!!!!!!")
			redirect(controller: 'user', action: 'index')
		}
	}

}