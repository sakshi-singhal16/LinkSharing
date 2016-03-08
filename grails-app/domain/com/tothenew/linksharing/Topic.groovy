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

	static transients = ['subscribedUsers']

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
			Subscription subscription = new Subscription(user: this.createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS)
					.save()

			log.info("${this.createdBy.name} subscribed to ${this.topicName}")

		}
	}
	static mapping = {
		sort topicName: "desc"
	}

	List getSubscribedUsers() {
		List users = Subscription.createCriteria().list {
			projections {
				property('user')
			}
			'topic' {
				eq('id', this.id)
			}
		}
		users
	}

	static List<TopicVO> getTrendingTopics() {
		List result = Resource.createCriteria().list() {


			projections {
				createAlias('topic', 't')
				groupProperty('t.id')
				property('t.topicName')
				property('t.visibility')
				property('t.createdBy')
				count('id', 'resourceCount')
			}
			maxResults 5
			eq('t.visibility', Visibility.PUBLIC)
			order("resourceCount", "desc")
			order("t.topicName", "desc")
		}
		List<TopicVO> topicVOList = []
		result.each {
			topicVOList.add(new TopicVO(id: it[0], topicName: it[1], visibility: it[2], createdBy: it[3], count: it[4]))

		}
		topicVOList
	}

	Boolean isPublic() {
		(this.visibility == Visibility.PUBLIC)
	}

	Boolean canBeViewedBy(User user) {
		User creator = this.createdBy
		(this.visibility == Visibility.PUBLIC || user == creator || user.isAdmin)
	}
}