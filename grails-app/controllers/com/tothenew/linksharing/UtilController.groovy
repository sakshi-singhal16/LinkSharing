package com.tothenew.linksharing

import grails.util.Holders
import org.springframework.beans.factory.annotation.Autowired

class UtilController {

	def UtilService
//	def newBean
//	def newBeanUsingConst
	def employeeBean
//	@Autowired
//	Person beanByType

	def index() {
		//render(grailsApplication.config.grails.var)
		int x = 2
		List l = [1, 2, 3, 4]
		render(view: 'trial', model: [x: x, list: l])


	}

	def save(User user) {
		//render("form saved")-
		if (user?.hasErrors())
			render(view: 'trial', model: [user1: user])
	}

	def cancel() {
		render("cancelled!")
	}

	def testUser() {
		/*def c= Holders.applicationContext.getBean('newBean')
		render "$c.....${c.properties}"
		render ("${UtilService.testUser()}")
		render ("${newBean.age}")*/
		UtilService.email()
	}

	def testResourceMethod() {
		List<User> users = Resource.getUsersWithUnreadResources()
		render "users"
		users.each { User user ->
			render "${user.unreadResources()}<br/><br/>	"
		}


	}

	def testBean(){
		render "------------------${employeeBean.properties}"
	}
}
