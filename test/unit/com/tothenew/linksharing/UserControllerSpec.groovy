package com.tothenew.linksharing

import com.tothenew.linksharing.CO.UserCO
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.plugins.testing.GrailsMockMultipartFile
import org.springframework.web.multipart.MultipartFile
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges

@Mock([User, Subscription, Topic, Resource])
@TestFor(UserController)
class UserControllerSpec extends Specification {
	User user

	def setup() {
		user = new User(firstName: "test", lastName: "user", userName: "test", password: "password",
				email: "abc@gmail.com", isActive: true)
	}

	@ConfineMetaClassChanges(Topic)
	def "index action"() {
		given:
		user.metaClass.getReadingItems = {
			[new ReadingItem()]
		}

		Topic.metaClass.static.getTrendingTopics = { ->
			[new Topic()]
		}
		user.metaClass.getSubscribedTopics = {
			[new Topic()]
		}

		controller.session.user = user

		when:
		controller.index()

		then:
		view == "/user/index"
		model.subscribedTopics.size == 1
		model.userObj == user
		model.trendingTopics.size() == 1
		model.readingItems.size() == 1

	}

/*	@IgnoreRest
	//NOT WORKING
	def "register action"() {
		given:
		UserCO co = new UserCO(firstName: "test", lastName: "user", userName: "test", password: "default",
				email: "test@test.com", confirmPassword: "default")
		co.photo = p
		when:
		controller.register(co)

		then:
		session.user == user
		response.redirectUrl == "/user/index"
		flash.message == "Welcome, ${user.name()}"

		where:
		p << [null, GrailsMockMultipartFile('myFile', 'some file contents'.bytes)]

	}*/

	def "test image action"() {

	}

	//NOT WORKING- HQL executeUpdate not supported
	def "test forgot action"() {
		given:
		user.email = email
		user.isActive = isActive
		user.save(validate: false)

		and:
		def mockedEmailService = Mock(EmailService)
		controller.emailService = mockedEmailService

		and:
		UtilService.metaClass.static.generateRandomPassword = { "something" }

		when:
		controller.forgot(email)

		then:
		user.password == "something"
		1 * mockedEmailService.sendMail(new EmailDTO())
		controller.flash.message == msg
		controller.flash.error == error
		response.redirectUrl == url

		where:
		email           | isActive | msg                                                             | error | url
		"abc@gmail.com" | true     | "Please check your inbox, 'abc@gmail.com' for updated password" | null  | "/login/index"

	}

}
