package com.tothenew.linksharing

class UtilController {

    def index() {
        //log.error ("Error in util controller")
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
}
