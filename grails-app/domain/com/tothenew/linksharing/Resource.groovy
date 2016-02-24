package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
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
	}
	static namedQueries = {
		search { ResourceSearchCO co ->
			if (co.topicId) {
				eq('topic.id', co.topicId)
			}
			if (co.visibility) {
				eq('topic.visibility', co.visibility)
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
}
