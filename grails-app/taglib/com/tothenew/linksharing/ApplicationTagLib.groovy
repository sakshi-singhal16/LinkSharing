package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Enums.Visibility


class ApplicationTagLib {
	//static defaultEncodeAs = [taglib: 'html']
	//static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
	static namespace = "ls"
	def assetResourceLocator
	def markAsRead = { attrs ->
		if (session.user) {
			Boolean isRead = Boolean.valueOf(attrs.isRead)
			out << link(controller: 'readingItem', action: 'changeIsRead', params: [isRead: !isRead, resourceId: attrs.id],
					isRead ? 'Mark as Unread ||' : 'Mark as Read ||')
		}
	}

	def showTrendingTopics = { attrs ->
		out << render(template: '/shared/trendingTopics', model: [trendingTopics: attrs.topics])
	}

	def showTopPosts = { attrs ->
		out << render(template: '/shared/topPosts', model: [topPosts: attrs.posts])

	}

	def canDeleteResource = { attrs, body ->
		User user = User.get(attrs.userId)
		Boolean canDelete = user.canDeleteResource(attrs.resourceId)
		if (canDelete)
			out << link(controller: 'resource', action: 'delete', params: [resourceId: attrs.resourceId], 'Delete ||')
	}

	def subscriptionCount = { attrs ->
		int count
		if (attrs.userId) {
			User user = User.get(attrs.userId)
			count = Subscription.countByUser(user)

		} else if (attrs.topicId) {
			Topic topic = Topic.get(attrs.topicId)
			count = Subscription.countByTopic(topic)
		}
		out << count
	}

	def resourceCount = { attrs ->
		Topic topic = Topic.get(attrs.topicId)
		int count = Resource.countByTopic(topic)
		out << count

	}

	def topicCount = { attrs ->
		User user = User.get(attrs.userId)
		int count = Topic.countByCreatedBy(user)
		out << count
	}

	def showResourceTags = { attrs ->
		String type = Resource.getResourceType(attrs.id)

		if (type == "DocumentResource")
			out << link(controller: 'documentResource', action: 'download', params: [resourceId: attrs.id], '|| Download ||')
		else {
			Resource resource = Resource.get(attrs.id)
			out << link(uri: resource.url, '|| View full site ||', target: '_blank')
		}
	}

	/*def showReadingItemTags = { attrs ->
		String type = Resource.getResourceType(attrs.id)
		if (type == "DocumentResource")
			out << link(controller: 'resource', action: 'show', '|| Download ||')
		else
			out << link(controller: 'resource', action: 'showPostPage', params: [id: attrs.id], '|| View full site ||', target: '_blank')
	}*/

	def showSubscribe = { attrs ->
		if (attrs.topicId) {
			if (session.user) {
				User user = session.user
				if (user.isSubscribed(attrs.topicId)) {
					Subscription subscription = Subscription.findByUserAndTopic(user, Topic.get(attrs.topicId))
					out << link(controller: 'subscription', action: 'delete', params: [subscriptionId: subscription.id], 'Unsubscribe')
				} else {
					out << link(controller: 'subscription', action: 'save', params: [topicId: attrs.topicId], 'Subscribe')
				}

			}
		}
	}
	def userImage = { attrs ->
		out << "<img src=\"/user/image/${attrs.userId}\" width=\"${attrs.width}\" height\"${attrs.height}\"/>"
	}

	def canUpdateTopic = { attrs ->
		Topic topic = Topic.get(attrs.id)
		User user = session.user
		List values = Visibility.values()
		if (topic.createdBy == user || user?.isAdmin) {

			out << g.select(from: values, name: 'visibility', id: 'visibility')
			out << "<div class=\"glyphicon glyphicon-edit\"></div>" << "<div class=\"glyphicon glyphicon-trash\"></div>"
		}


	}
	def showSeriousness = { attrs ->
		User user = session.user
		Topic topic = Topic.get(attrs.id)
		List values = Seriousness.values()
		out << g.select(from: values, value: user?.getSubscription(topic), name: 'seriousness', id: 'seriousness')
	}
}
