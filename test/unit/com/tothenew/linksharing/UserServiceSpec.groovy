package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
class UserServiceSpec extends Specification {

	def "email sending"() {
		given:
		def mockedEmailService = Mock(EmailService)
		service.emailService = mockedEmailService
//		mock email service
		service.metaClass.getUsersWithUnreadItems = { ->
			[new User()]
		}
		service.metaClass.getUnreadResources = { User user ->
			[new LinkResource()]
		}

		when:
		service.sendUnreadItemsEmail()

		then:
		1 * mockedEmailService.sendUnreadResourcesEmail(_, _)

	}
}
