package com.tothenew.linksharing

class ResourceRatingController {

	def index() {}

	def save(Long resourceId, int newRating) {

//		ResourceRating resourceRating=new ResourceRating(resource: Resource.get(resourceId), user: session.user, rating: rating)
//		render "-------${resourceRating.properties}"
		Resource resource = Resource.get(resourceId)
		User user = session.user
		if (ResourceRating.executeUpdate("update ResourceRating set rating=:score where resource=:resourceObj and user=:userObj",
				[score: newRating, resourceObj: resource, userObj: user]) == 1) {
			render("Rating updated!")
		} else {
			render("error saving rating")
		}

	}
}
