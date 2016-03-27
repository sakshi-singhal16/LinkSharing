package com.tothenew.linksharing

import com.tothenew.linksharing.CO.UserCO
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.web.multipart.MultipartFile
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges

@Mock([User, Subscription, Topic, Resource])
@TestFor(UserController)
class UserControllerSpec extends Specification {

	@ConfineMetaClassChanges(Topic)
	def "index action"() {
		given:
		User user = new User(firstName: "test", lastName: "user", userName: "test", password: "password",
				email: "testuser1@test.com", isActive: true)
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

	def "register action"() {
		given:
		UserCO co = new UserCO(firstName: "test", lastName: "user", userName: "test", password: "default",
				email: "test@test.com", confirmPassword: "default")
		//PHOTO????
		when:
		controller.register(co)

		then:
		session.user == user
		response.redirectUrl == "/user/index"
		flash.message == "Welcome, ${user.name()}"

	}


}
