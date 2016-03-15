package com.tothenew.linksharing.CO

import com.tothenew.linksharing.User
import grails.validation.Validateable

/**
 * Created by sakshi on 14/3/16.
 */
@Validateable
class UpdatePasswordCO {
	String oldPassword
	String password
	String confirmPassword
	Long id

	User getUser() {
		User.get(id)
	}
	static constraints = {
		importFrom(User, include: ['password', 'confirmPassword'])
//		oldPassword matches: getUser().password
	}
}
