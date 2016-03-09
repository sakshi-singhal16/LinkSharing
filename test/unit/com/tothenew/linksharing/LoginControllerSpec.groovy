package com.tothenew.linksharing

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

@Mock([User])
@TestFor(LoginController)
class LoginControllerSpec extends Specification {


	def "index: if session user is set, redirect to user index action"() {
		given:
		controller.session.user = new User()

		when:
		controller.index()

		then:
		response.forwardedUrl == "/user/index"

	}

	def "index: if session user is not set, render index view"() {
		when:
		controller.index()

		then:
		view == "/login/index"

	}


	def "login: if user is active, redirect"() {
		given:
		User user = new User(firstName: "test", lastName: "user", userName: testUserName, password: testPassword,
				email: "testuser1@test.com", isActive: true)
		user.save()

		when:
		controller.login(testUserName, testPassword)

		then:
		controller.session.user == user
		response.redirectUrl == "/user/index"

		where:
		testUserName | testPassword
		"test_user"  | "password"
	}

	def "login: if user is not active, set flash message"() {
		given:
		User user = new User(firstName: "test", lastName: "user", userName: testUserName, password: testPassword,
				email: "testuser2@test.com", isActive: false)
		user.save()

		when:
		controller.login(testUserName, testPassword)

		then:
		flash.message == "Your account is not active"

		where:
		testUserName | testPassword
		"test_user"  | "password"
	}


	def "login: user is not found"() {

		when:
		controller.login(testUserName, testPassword)

		then:
		flash.message == "User not found"
		response.text == flash.message

		where:
		testUserName | testPassword
		"abc"        | "password"
	}


	def "register: user is saved successfully"() {
		given:
		User user = new User(firstName: "test", lastName: "user", userName: "test", password: "default",
				email: "testuser3@test.com", isActive: true)

		when:
		controller.register(user)

		then:
		controller.session.user == user
		response.redirectUrl == "/user/index"
		User.count == 1

	}

	def "register: user is not saved successfully"() {
		given:
		User user = new User(firstName: "test", lastName: "user", userName: "test", password: "pswd",
				email: "testuser4@test.com", isActive: true)

		when:
		controller.register(user)

		then:
		response.text == "Could not save user"

	}

	def "logout: forward to login index upon logout"() {
		when:
		controller.logout()

		then:
		!session.user
		response.forwardedUrl == "/login/index"

	}
}