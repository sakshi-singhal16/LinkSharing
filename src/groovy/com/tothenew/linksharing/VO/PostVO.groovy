package com.tothenew.linksharing.VO


class PostVO {
	Long userId
	Long topicId
	Long resourceId
	Boolean isRead
	String user
	Date dateCreated
	String userName
	String topicName
	String description
	String url
	String filePath

	String toString() {
		"$user, $topicName, $description"
	}

}
