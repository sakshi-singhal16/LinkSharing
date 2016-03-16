package com.tothenew.linksharing

import grails.converters.JSON

class ResourceRatingController {


	def save(Long resourceId, int newRating) {
		Resource resource = Resource.get(resourceId)
		User user = session.user
		if (ResourceRating.executeUpdate("update ResourceRating set rating=:score where resource=:resourceObj and user=:userObj",
				[score: newRating, resourceObj: resource, userObj: user]) == 1) {
			render([message: "Rating updated"] as JSON)
		} else {
			render([error: "Could not update rating"] as JSON)
		}
	}
}
