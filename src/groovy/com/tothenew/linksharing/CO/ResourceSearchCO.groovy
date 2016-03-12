package com.tothenew.linksharing.CO

import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.User
import grails.validation.Validateable

/**
 * Created by sakshi on 23/2/16.
 */

@Validateable
class ResourceSearchCO extends SearchCO {
	Long id
	Long topicId
	Visibility visibility

	User getUser() {
		User.get(id)
	}
}
