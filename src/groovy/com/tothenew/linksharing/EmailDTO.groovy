package com.tothenew.linksharing

import grails.validation.Validateable

/**
 * Created by sakshi on 12/3/16.
 */
@Validateable
class EmailDTO {
	String to
	String view
	String subject
	Map model
	String content

	static constraints = {

	}
}
