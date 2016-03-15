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
			ReadingItem readingItem = new ReadingItem(isRead: false, user: it, resource: resource)
			User creator = readingItem.resource.createdBy
			if (it.equals(creator)) {
				readingItem.isRead = true
			}
			ReadingItem readingItemSaved = readingItem.save(flush: true)
			if (readingItemSaved)
				log.info("--------${readingItem} saved!!!!!!!!!!!!")
			else {
				log.error "reading item not saved*********************************************"
			}
//			it.addToReadingItems(readingItem)
			it.readingItems.add(readingItem)
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

			render(view: '/shared/search', model: [results: resources, topics: trendingTopics, posts: topPosts, q: co.q])
		} else {
			flash.error = "No search text entered"
			if (!session.user) {
				List<Resource> topPosts = Resource.getTopPosts()
				List<Resource> recentPosts = Resource.getRecentPosts()
				render(view: '/login/index', model: [topPosts: topPosts, recentPosts: recentPosts])
			} else
				render(view: '/user/index', model: [userObj: session.user])

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

	def updateDescription(Long resourceId, String newDescription) {
		Resource resource = Resource.get(resourceId)
		if (newDescription) {
			if (resource.description == newDescription) {
				flash.message = "No changes made"
			} else {
				resource.description = newDescription
				if (resource.save(flush: true)) {
					flash.message = "Resource description updated"
				} else {
					flash.error = "Error updating description"
				}
			}
		} else {
			flash.message = "No description entered"
		}
		redirect(controller: 'resource', action: 'showPostPage', params: [id: resourceId])
	}
}