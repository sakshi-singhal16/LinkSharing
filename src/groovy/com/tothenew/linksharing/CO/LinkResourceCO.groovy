package com.tothenew.linksharing.CO

import grails.validation.Validateable

/**
 * Created by sakshi on 1/3/16.
 */
@Validateable
class LinkResourceCO {
	String url
	String description
	Long topicId
}
