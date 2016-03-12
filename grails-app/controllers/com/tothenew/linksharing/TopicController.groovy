package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import com.tothenew.linksharing.CO.TopicCO
import com.tothenew.linksharing.Enums.Visibility
import grails.converters.JSON

class TopicController {
	def emailService

	def index(Long id) {
		Topic topic = Topic.get(id)

//		render("$topic")
		List<User> subscribedUsers = topic.getSubscribedUsers()
		List<Resource> posts = Resource.findAllByTopic(topic)
		render(view: 'index', model: [users: subscribedUsers, topicObj: topic, posts: posts])
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

		if (topic.save(flush: true)) {
			flash.message = "New topic created"
			render([message: flash.message] as JSON)
		} else {
			log.error("Error saving topic!")
			flash.error = "Error saving topic!"
			render([[error: flash.error]])
//			redirect(controller: 'user', action: 'index')
		}
	}

	def update(String topicName, Long id, String visibility) {

		Visibility visibility1 = Visibility.convertToEnum(visibility)
		User user = session.user
		println("$user-----------------------------------")
		if (Topic.executeUpdate("update Topic set visibility=:v where id=:i", [v: visibility1, i: id]) == 1) {
			render([message: 'Status changed successfully'] as JSON)
		} else
			render([error: 'Error while updating status'] as JSON)
		println(" ------------------------ ${topicName} ---------------- ${visibility} ")
	}

	def invite(Long topicId, String email) {
		if (Topic.get(topicId)) {
			EmailDTO emailDTO = new EmailDTO(to: email, model: [topicId: topicId], view: "/email/_invite", subject: "Link Sharing| Invitation to follow topic")
			emailService.sendMail(emailDTO)
			render "email sent!"
		} else {
			render("error inviting: topic not found!")
		}

	}

	def join(Long topicId) {
		Subscription subscription = new Subscription(topic: Topic.get(topicId), user: session.user)
		if (subscription.save(flush: true)) {
			render("Susbcribed to topic successfully")
		} else {
			render("error subscribing")
		}
	}
}
