package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.VO.RatingInfoVO
import com.tothenew.linksharing.VO.TopicVO
import javassist.tools.rmi.ObjectNotFoundException

class ResourceController {
	def grailsApplication

	void addToReadingItems(Long resourceId) {
		Resource resource = Resource.get(resourceId)
		List<User> subscribedUsers = resource.topic.getSubscribedUsers()
		subscribedUsers.each {
			println "@@@@@@@@@@@@@@@@@" + it

			ReadingItem readingItem = new ReadingItem(isRead: false, user: it, resource: resource, reader: User.get(1))
			readingItem.user = it
			if (it.equals(session.user)) {
				readingItem.isRead = true
			}

			ReadingItem readingItemSaved = readingItem.save()
			if (readingItemSaved)
				log.info("--------${readingItem} saved!!!!!!!!!!!!")
			else {
				log.error "reading item not saved*********************************************"
			}
			it.addToReadingItems(readingItem)
			//it.readingItems.add(readingItem)
		}

	}

	def show(Long id) {
		Resource resource = Resource.get(id)
		RatingInfoVO ratingInfoVO = resource.getRatingInfo()
		render("Ratings: ${ratingInfoVO}")
	}

	def search(ResourceSearchCO co) {
		if (co.q) {
			co.visibility = Visibility.PUBLIC
			List<Resource> resources = Resource.search(co).list()
			List<TopicVO> trendingTopics = Topic.getTrendingTopics()
			List<Resource> topPosts = Resource.getTopPosts()

			render(view: '/shared/search', model: [results: resources, topics: trendingTopics, posts: topPosts])
		} else {
			render("Parameter q not set")
		}
	}

	def delete(Long id) {
		try {
			Resource resource = Resource.load(id)
			if (session.user.canDeleteResource(id)) {
				if (resource.delete())
					render "$resource deleted successfully"
				else {
					render "resource not deleted"
				}
			}
		}
		catch (ObjectNotFoundException e) {
			render "error deleting resource"
			log.error "Error loading resource!!"
		}
//		render("in delete with $id")
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