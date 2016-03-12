package com.tothenew.linksharing.CO

import com.tothenew.linksharing.User
import grails.validation.Validateable

/**
 * Created by sakshi on 1/3/16.
 */
@Validateable
class TopicCO {
	String topicName
	User createdBy
	String visibility
}
