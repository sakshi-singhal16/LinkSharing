package com.tothenew.linksharing.VO

import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.User

/**
 * Created by sakshi on 24/2/16.
 */
class TopicVO {
	Long id
	String name
	Visibility visibility
	Integer count
	User createdBy
}
