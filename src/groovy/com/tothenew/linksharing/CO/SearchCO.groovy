package com.tothenew.linksharing.CO

import grails.validation.Validateable

/**
 * Created by sakshi on 23/2/16.
 */
@Validateable
class SearchCO {
	String q
	Integer max
	Integer offset
	String order
	String sort
}
