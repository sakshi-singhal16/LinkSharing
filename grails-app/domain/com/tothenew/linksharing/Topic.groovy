package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.VO.TopicVO


class Topic {
	String topicName
	User createdBy
	Date dateCreated
	Date lastUpdated

	Visibility visibility

	static hasMany = [resources: Resource, subscriptions: Subscription]

	static constraints = {
		topicName blank: false, nullable: false, unique: 'createdBy'
		createdBy nullable: false

	}

	String toString() {
		"Topic --> ${topicName}"
	}

	def afterInsert() {
		Topic.withNewSession {
			Subscription subscription = new Subscription(user: this.createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS).save()

			log.info("${this.createdBy.name} subscribed to ${this.topicName}")

		}


	}
	static mapping = {
		sort topicName: "desc"
	}

/*	static List<TopicVO> getTrendingTopics() {
		List result = Resource.createCriteria().list(){
			projections {
				createAlias('topic','t')
				groupProperty('t')
				count('id', 'resourceCount')
			}
			order("resourceCount", "desc")
			order("t.topicName", "desc")
		}

	}*/
}

