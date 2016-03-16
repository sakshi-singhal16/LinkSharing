package com.tothenew.linksharing.CO

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

/**
 * Created by sakshi on 13/3/16.
 */
@Validateable
class UserCO {
	String firstName
	String lastName
	String email
	MultipartFile photo
	String userName
	String password
	String confirmPassword
}
