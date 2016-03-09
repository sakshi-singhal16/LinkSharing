package com.tothenew.linksharing

class ResourceRatingController {

	def index() {}
	def save(Long resourceId, int rating){

		ResourceRating resourceRating=new ResourceRating(resource: Resource.get(resourceId), user: session.user, rating: rating)
		resourceRating.save(flush:true)
	}
}
