package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.VO.RatingInfoVO
import com.tothenew.linksharing.VO.TopicVO

class ResourceController {

	def show(Long id) {
		Resource resource = Resource.get(id)
		RatingInfoVO ratingInfoVO = resource.getRatingInfo()
		render("Ratings: ${ratingInfoVO}")
	}

	def search(ResourceSearchCO co) {
		if (co.q) {
			co.visibility = Visibility.PUBLIC
			List<Resource> resources = Resource.search(co).list()
			render(view: '/search', model: [results: resources])
		} else {
			render("Parameter q not set")
		}
	}

	def delete(Long id) {
		/*try {
			Resource resource = Resource.load(id)
			if(resource.delete())
			render "$resource deleted successfully"
			else{
				render "resource not deleted"
			}
		}
		catch (ObjectNotFoundException e) {
			render "error deleting resource"
			log.error "Error loading resource!!"
		}*/
		render("in delete with $id")
	}

	def showPostPage(Long id) {
		List<TopicVO> topics = []
		topics = Topic.getTrendingTopics()
		Resource resource = Resource.get(id)
		if (resource.canBeViewedBy(session.user))
			render(view: 'showPostPage', model: [trendingTopics: topics, resource: resource])
		else
			render("You are not authorized to view this resource")
	}


}