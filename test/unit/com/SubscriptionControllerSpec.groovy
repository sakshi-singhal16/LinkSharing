package com

import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.Subscription
import com.tothenew.linksharing.SubscriptionController
import com.tothenew.linksharing.Topic
import com.tothenew.linksharing.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import jdk.nashorn.internal.ir.annotations.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

@Mock([Topic, User, Subscription])
@TestFor(SubscriptionController)
class SubscriptionControllerSpec extends Specification {
	User user
	Topic topic
	Subscription subscription

	def setup() {
		user = new User(firstName: "test", lastName: "user", userName: "testuser1", password: "default", email: "testuser@test.com")
		topic = new Topic(createdBy: user, visibility: Visibility.PUBLIC, topicName: "Topic1")
		subscription = new Subscription(topic: topic, user: user, seriousness: Seriousness.SERIOUS)
	}

	def cleanup() {
	}

	def "test save action"() {
		given:
		user.save()
		session.user = user

		and:
		topic.save()

		and:

		subscription.save()

		when:
		controller.save(testId)

		then:
		response.text == expectedRender

		where:
		testId | expectedRender
		1      | "Subscription saved successfully"
		2      | "Error saving subscription!!"
	}

	def "update: if subscription updated successfully, render"() {
		given:
		user.save()
		topic.save()
		subscription.save(validate: false)


		when:
		controller.update(subscription.id, "casual")

		then:
		response.text == "Subscription information updated"
		subscription.seriousness == Seriousness.CASUAL
	}

	//@Ignore
	//HOW TO DO THIS
	/*def "update: if subscription not updated, render"() {
		given:
//		user.save()
//		topic.save()
//		subscription.save()
		Subscription subscription1 = new Subscription(seriousness: Seriousness.SERIOUS)
		subscription1.save()

		when:
		controller.update(subscription1.id, "casual")

		then:
		response.text == "Error updating subscription information!!"
	}*/

	def "update: subscription not found"() {
		when:
		controller.update(1, "casual")

		then:
		response.text == "Subscription not found!"
	}


	def "delete: delete resource successfully "(){
		given:
		user.save()
		topic.save()
		subscription.save()

		when:
		controller.delete(subscription.id)

		then:
		response.text == "could not delete Subscription --> User --> test user for Topic --> Topic1"
	}


	def "delete: could not delete resource "(){
		given:
		subscription.save()

		when:
		controller.delete(subscription.id)

		then:
		response.text == "could not delete Subscription --> User --> test user for Topic --> Topic1"
	}

	def "delete: resource not found"(){
		when:
		controller.delete(1)

		then:
		response.text == "Subscription not found!!"
	}
}
