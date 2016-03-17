package com.tothenew.linksharing

import com.tothenew.linksharing.CO.TopicSearchCO
import com.tothenew.linksharing.Enums.Visibility
import grails.transaction.Transactional

@Transactional
class TopicService {

	List<Topic> search(TopicSearchCO topicSearchCO) {
		println "${topicSearchCO.properties}-----------------------------------------------------------------------------"
		Topic.findAllByCreatedByAndVisibility(topicSearchCO.user, topicSearchCO.visibility)
	}
}
