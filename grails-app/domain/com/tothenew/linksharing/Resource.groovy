package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.VO.RatingInfoVO

abstract class Resource {


	User createdBy
	String description
	Date dateCreated
	Date lastUpdated

	static hasMany = [readingIntems: ReadingItem, resourceRatings: ResourceRating]
	static belongsTo = [topic: Topic]
	static constraints = {
		topic nullable: false
		createdBy nullable: false
		description blank: false, nullable: false
	}
	static transients = ['ratingInfo']
	static mapping = {
		description(type: 'text')
//		tablePerHierarchy(false)
	}
	static namedQueries = {
		search { ResourceSearchCO co ->
			if (co.topicId) {
				'topic' {
					eq('id', co.topicId)

					if (co.visibility) {
						eq('visibility', co.visibility)
					}

				}

				ilike('description', "%${co.q}%")

			}
		}
	}

	RatingInfoVO getRatingInfo() {
		List result = ResourceRating.createCriteria().get {
			projections {
				count('id', 'ratingCount')
				sum('rating')
				avg('rating')
			}
			eq('resource', this)
			//order('accountCount', 'desc')
		}

		new RatingInfoVO(totalVotes: result[0], totalScore: result[1], avgScore: result[2])
	}

	static List<Resource> getTopPosts() {
		List result = ResourceRating.createCriteria().list {
			projections {
				groupProperty('resource.id')
				count('id', 'numberOfVotes')
			}
			maxResults 5
			order("numberOfVotes", "desc")
		}
		List<Resource> topResources = Resource.getAll(result.collect { it[0] })
		topResources
	}

	static List<Resource> getRecentPosts() {
		List<Resource> result = Resource.createCriteria().list {
			'topic' {
				eq('visibility', Visibility.PUBLIC)
			}
			maxResults 5
			order("lastUpdated", "desc")
		}
		result
		/*
		List<Resource> topResources=Resource.getAll(result.collect {it[0]})
		topResources*/
	}

	Boolean canBeViewedBy(User user) {
		this.topic.canBeViewedBy(user)
	}

	static String getResourceType(Long resourceId) {
		Resource resource = Resource.get(resourceId)
		if (resource instanceof DocumentResource)
			return "DocumentResource"
		else
			return "LinkResource"

	}

	void deleteFile() {
		log.info "**************This is implemented in DocumentResource class**********"
	}

	/*def afterInsert() {
		Resource.withNewSession {
			List<User> subscribedUsers = this.topic.getSubscribedUsers()
			subscribedUsers.each {

				ReadingItem readingItem = new ReadingItem(isRead: false, user: it, resource: this)
				if (it == this.createdBy) {
					readingItem.isRead = true
				}
				readingItem.save(flush: true)
				log.info("--------${readingItem} saved!!!!!!!!!!!!")
			}
		}
	}*/
}
