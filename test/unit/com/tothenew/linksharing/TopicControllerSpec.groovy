package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import com.tothenew.linksharing.CO.TopicCO
import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Enums.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

@Mock([Topic, User, Subscription])
@TestFor(TopicController)
class TopicControllerSpec extends Specification {
	User user
	Topic publicTopic, privateTopic
	Subscription subscription
	ResourceSearchCO resourceSearchCO

	def setup() {
		user = new User(firstName: "test", lastName: "user", userName: "testuser1", password: "default",
				email: "testuser@test.com")
		publicTopic = new Topic(createdBy: user, visibility: Visibility.PUBLIC, topicName: "Topic1")
		privateTopic = new Topic(createdBy: user, visibility: Visibility.PRIVATE, topicName: "Topic1")
		subscription = new Subscription(user: user, topic: privateTopic, seriousness: Seriousness.SERIOUS)

	}

	def "show: if topic is public, render"() {
		given:
		publicTopic.save()

		and:
		resourceSearchCO = new ResourceSearchCO(topicId: publicTopic.id, visibility: Visibility.PUBLIC)


		when:
		controller.show(resourceSearchCO)


		then:
		response.text == "Public topic.. Success"

	}

	def "show: if topic not found, redirect and flash"() {
		given:
		resourceSearchCO = new ResourceSearchCO(topicId: 1, visibility: Visibility.PUBLIC)

		when:
		controller.show(resourceSearchCO)

		then:
		response.redirectUrl == "/login/index"
		flash.message == "Topic not found"

	}

	def "show: if topic is private and user is subscribed to it, render"() {
		given:
		user.save(flush: true)
		session.user = user
		privateTopic.save(flush: true)
		subscription.save(flush: true)
		ResourceSearchCO resourceSearchCO = new ResourceSearchCO(topicId: privateTopic.id, visibility: Visibility.PRIVATE)

		when:
		controller.show(resourceSearchCO)

		then:
		response.text == "Private topic.. Success"


	}

	def "show: if topic is private but user is not subscribed, redirect and flash"() {
		given:
		session.user = new User().save(validate: false)
		Topic topic = new Topic(topicName: "topicX", createdBy: new User().save(validate: false), visibility: Visibility.PRIVATE)
		topic.save(flush: true)
		ResourceSearchCO resourceSearchCO = new ResourceSearchCO(topicId: topic.id, visibility: Visibility.PRIVATE)

		when:
		controller.show(resourceSearchCO)

		then:
		response.redirectUrl == "/login/index"
		flash.message == "Private topic. Subscribe to view this topic"
	}

	def "save: topic saved successfully "() {
		given:
		user.save()
		TopicCO topicCO = new TopicCO(topicName: "test topic", createdBy: user, visibility: "Public")
		controller.session.user = user

		when:
		controller.save(topicCO)

		then:
		flash.message == "Topic --> test topic saved"
		response.text == flash.message


	}


	def "save: topic could not be saved "() {
		given:
		TopicCO topicCO = new TopicCO(topicName: "Test topic", createdBy: new User(), visibility: "Public")

		when:
		controller.save(topicCO)

		then:
		flash.message == "Error saving Topic --> Test topic!!!!!!"
		response.redirectUrl == "/user/index"


	}
}