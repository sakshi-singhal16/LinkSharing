package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Enums.Visibility


class ApplicationTagLib {
	static namespace = "ls"

	def markAsRead = {

		attributes ->
			if (session.user) {
				Long resourceId = attributes.id
				Boolean isRead = !attributes.isRead
				if (attributes.isRead)
					out << "<a href = '' class = 'markReadStatus' resourceId = ${resourceId} isRead = ${isRead}>" +
							"Mark as unread ||</a>"
				else
					out << "<a href = '' class = 'markReadStatus' resourceId = ${resourceId} isRead = ${isRead}>" +
							"Mark as read ||</a>"
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
		Resource resource = Resource.get(attrs.resourceId)
		if (canDelete)
			if ((resource instanceof DocumentResource)) {
				out << link(controller: 'documentResource', action: 'delete', params: [resourceId: attrs.resourceId], 'Delete ||')
			} else {
				out << link(controller: 'linkResource', action: 'delete', params: [resourceId: attrs.resourceId], 'Delete ||')
			}
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
			out << link(class: "pull-right", controller: 'documentResource', action: 'download', params: [resourceId: attrs.id], '|| Download ||')
		else {
			Resource resource = Resource.get(attrs.id)
			out << link(class: "pull-right", uri: resource.url, '|| View full site ||', target: '_blank')
		}
	}

	def showSubscribe = { attrs ->
		if (attrs.topicId) {
			if (session.user) {
				User user = session.user
				if (user.isSubscribed(attrs.topicId)) {
//					Subscription subscription = Subscription.findByUserAndTopic(user, Topic.get(attrs.topicId))
					out << link('Unsubscribe', class: 'unsubscribe', topicId: attrs.topicId)
				} else {
					out << link('Subscribe', class: 'subscribe', topicId: attrs.topicId)
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

			out << g.select(from: values, name: 'visibility', id: 'v', topicName: topic.topicName, topicId: attrs.id, value: topic.visibility)
			out << "<div class=\"glyphicon glyphicon-edit\" id=\"editTopicIcon\" style=\"margin-left:20px\"></div>"
//			out << "<a class=\"glyphicon glyphicon-trash\"  style=\"margin-left:10px\"></div>"
			out << link(controller: 'topic', action: 'delete', class: 'glyphicon glyphicon-trash', style: 'margin-left:10px', params: [topicId: attrs.id])
		}
	}
	def showSeriousness = { attrs ->
		User user = session.user
		Topic topic = Topic.get(attrs.id)
		List values = Seriousness.values()
		out << g.select(from: values, value: user?.getSubscription(topic), name: 'seriousness', id: 'seriousness', topicId: attrs.id)
	}
	def showActiveStatus = { attrs ->
		User user = User.get(attrs.userId)
		if (user.isActive)
			out << "Yes"
		else
			out << "No"
	}
	def showActivateLink = { attrs ->
		User user = User.get(attrs.userId)
		out << link(controller: 'user', action: 'toggleActive', params: [userId: attrs.userId], user.isActive ? 'Deactivate' : 'Activate')

	}
	def showResourceEdit = { attrs ->
		Resource resource = Resource.get(attrs.id)
		if (session.user == resource.createdBy || session.user.isAdmin)
			out << "<a id=\"openModal\" href=\"#editModal\" data-toggle=\"modal\">Edit</a>"
	}
}