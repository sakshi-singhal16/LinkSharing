package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Enums.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(User)
class UserSpec extends Specification {

	User user



	void "test"() {
		expect:
		true
	}

	@Unroll("Executing #sno")
	def "test user validations"() {
		given:
		User user = new User(firstName: fn,
				lastName: ln, password: pwd, email: em, userName: uname)

		when:
		Boolean result = user.validate()

		then:
		result == expectedResult

		where:
		sno | fn       | ln        | pwd        | em               | uname | expectedResult
		1   | null     | "singhal" | "password" | "sakshi@ttn.com" | "ss"  | false
		2   | ""       | "singhal" | "password" | "sakshi@ttn.com" | "ss"  | false
		3   | "sakshi" | null      | "password" | "sakshi@ttn.com" | "ss"  | false
		4   | "sakshi" | ""        | "password" | "sakshi@ttn.com" | "ss"  | false
		5   | "sakshi" | "singhal" | null       | "sakshi@ttn.com" | "ss"  | false
		6   | "sakshi" | "singhal" | ""         | "sakshi@ttn.com" | "ss"  | false
		7   | "sakshi" | "singhal" | "p"        | "sakshi@ttn.com" | "ss"  | false
		8   | "sakshi" | "singhal" | "password" | null             | "ss"  | false
		9   | "sakshi" | "singhal" | "password" | ""               | "ss"  | false
		10  | "sakshi" | "singhal" | "password" | "sakshi@ttn.com" | null  | false
		11  | "sakshi" | "singhal" | "password" | "sakshi@ttn.com" | ""    | false
		12  | "sakshi" | "singhal" | "password" | "sakshi@ttn.com" | "ss"  | true

	}

	def "email id of user should be unique"() {
		given:
		User user = new User(firstName: "sakshi", lastName: "singhal", email: "sakshi@tothenew.com", password: "sakshi", userName: "ss")

		when:
		user.save()


		then:
		user.count() == 1  //count is static method, works on both Class and object

		when:
		User user2 = new User(firstName: "priyanka", lastName: "gupta", email: "sakshi@tothenew.com", password: "sakshi", userName: "pg")
		user2.save()

		then:
		user.count() == 1
		user2.errors.allErrors.size() == 1
		user2.errors.getFieldErrorCount("email") == 1

	}

	@Unroll("Tesing get name method for  #sno")
	def "test get name"() {
		given:
		user.firstName = fn
		user.lastName = ln
		user.email = "abc@ttn.com"
		user.userName = "ss"
		user.password = "password"


		when:
		String receivedResult = user.getName()


		then:
		receivedResult == expectedResult

		where:
		sno | fn       | ln        | expectedResult
		1   | null     | "singhal" | "singhal"
		2   | "sakshi" | null      | "sakshi"
		3   | "sakshi" | "singhal" | "sakshi singhal"

	}

	def "Test toString method of User class"() {
		given:
		user.firstName = "test"
		user.lastName = "user"

		when:
		String s = "hello $user"

		then:
		s == "hello User --> test user"

	}

	@Mock([Topic, User, Subscription])
	@TestFor(SubscriptionController)
	static class SubscriptionControllerSpec extends Specification {
		User user
		Topic topic
		Subscription subscription

		def setup() {
			user = new User(firstName: "test", lastName: "user", userName: "testuser1", password: "default", email: "testuser@test.com")
			topic = new Topic(createdBy: user, visibility: Visibility.PUBLIC, topicName: "Topic1")
			subscription = new Subscription(topic: topic, user: user, seriousness: Seriousness.SERIOUS)
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


		def "delete: delete resource successfully "() {
			given:
			user.save()
			topic.save()
			subscription.save()

			when:
			controller.delete(topic.id)

			then:
			response.text == "could not delete Subscription --> User --> test user for Topic --> Topic1"
		}


		def "delete: could not delete resource "() {
			given:
			subscription.save()

			when:
			controller.delete(topic.id)

			then:
			response.text == "could not delete Subscription --> User --> test user for Topic --> Topic1"
		}

		def "delete: resource not found"() {
			when:
			controller.delete(1)

			then:
			response.text == "Subscription not found!!"
		}
	}
}
