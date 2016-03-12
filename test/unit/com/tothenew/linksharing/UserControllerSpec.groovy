package com.tothenew.linksharing

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@Mock([User, Subscription])
@TestFor(UserController)
class UserControllerSpec extends Specification {



	def "index action"() {
		given:
		User user = new User(firstName: "test", lastName: "user", userName: "test", password: "password",
				email: "testuser1@test.com", isActive: true)
		controller.session.user = user

		when:
		controller.index()

		then:
		view == "/user/index"
		model.subscribedTopics == user.subscribedTopics

	}
}
