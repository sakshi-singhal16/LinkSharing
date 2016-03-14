package com.tothenew.linksharing

import com.tothenew.linksharing.CO.TopicSearchCO
import grails.transaction.Transactional

@Transactional
class SubscriptionService {

    List<Topic> search(TopicSearchCO topicSearchCO) {
        topicSearchCO.getUser().getSubscribedTopics()
    }
}
