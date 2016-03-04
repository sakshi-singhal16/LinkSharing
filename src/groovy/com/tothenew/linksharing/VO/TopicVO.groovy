package com.tothenew.linksharing.VO

import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.User


class TopicVO {
	Long id
	String topicName
	Visibility visibility
	Integer count
	User createdBy

	String toString() {
		"${id}--> topic name: $topicName, $visibility"
	}
}
