package com.tothenew.linksharing.CO

import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.User

/**
 * Created by sakshi on 11/3/16.
 */
class TopicSearchCO extends SearchCO {
	Visibility visibility
	Long userId

	User getUser() {
		User.get(userId)
	}

}
