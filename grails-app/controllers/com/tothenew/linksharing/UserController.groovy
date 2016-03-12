package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import com.tothenew.linksharing.CO.TopicSearchCO
import com.tothenew.linksharing.CO.Util
import com.tothenew.linksharing.VO.TopicVO

class UserController {
	def assetResourceLocator
	def topicService
	def resourceService
	def subscriptionService
	def emailService

	def index() {
		List<Topic> subscribedTopics = session.user.getSubscribedTopics()
		List<TopicVO> trendingTopics = Topic.getTrendingTopics()
		List<ReadingItem> readingItems = session.user.getReadingItems()
		User user = session.user
		render(view: "index",
				model: [subscribedTopics: subscribedTopics, userObj: user, trendingTopics: trendingTopics, readingItems: readingItems])
	}

	def register(User user) {
		user.isActive = true
		user.isAdmin = false
		if (user.save(flush: true)) {
			session.user = user
			redirect(controller: 'user', action: 'index')
		} else {
			render(view: '/login/index', model: [user: user])
		}
	}

	def image(Long id) {
		User user = User.get(id)
		byte[] image
		if (!user.photo) {
			image = assetResourceLocator.findAssetForURI('user.png').byteArray
		} else {
			image = user.photo
		}
		OutputStream out = response.getOutputStream()
		out.write(image)
		out.flush()
		out.close()
	}

	def profile(ResourceSearchCO co) {
		co.max = co.max ?: 5
		co.offset = co.offset ?: 0
		TopicSearchCO topicSearchCO = new TopicSearchCO(userId: co.id, visibility: co.visibility, max: params.max, offset: params.offset)
		List<Topic> topicsCreated = topicService.search(topicSearchCO)
		List<Resource> postsCreated = resourceService.search(co)
		List<Topic> subscribedTopics = subscriptionService.search(topicSearchCO)
		render(view: 'profile', model: [
				userObj         : co.getUser(),
				topicsCreated   : topicsCreated,
				subscribedTopics: subscribedTopics,
				postsCreated    : postsCreated,
				resourceSearchCo: co])
	}

	def forgot(String email) {
		User user = User.findByEmail(email)
		Long id = user.id
		if (user && user.isActive) {
			String newPassword = Util.generateRandomPassword() as String
			if (User.executeUpdate('update User set password=:newPswd where id=:id1', [newPswd: newPassword, id1: id]) == 1) {
				render("password updated<br/>")
				EmailDTO emailDTO = new EmailDTO(to: email, model: [newPassword: newPassword], view: "/email/_password", subject: "Link Sharing| New password")
				emailService.sendMail(emailDTO)
				render("email sent")
			} else {
				render "could not update"
			}
		} else {
			render "user not active"
		}
	}
}
