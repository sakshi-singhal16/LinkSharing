package com.tothenew.linksharing

import com.tothenew.linksharing.CO.ResourceSearchCO
import com.tothenew.linksharing.CO.TopicSearchCO
import com.tothenew.linksharing.CO.UpdatePasswordCO
import com.tothenew.linksharing.CO.UserCO
import com.tothenew.linksharing.CO.UserSearchCO
import com.tothenew.linksharing.CO.Util
import com.tothenew.linksharing.VO.TopicVO
import grails.converters.JSON

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

	def register(UserCO co) {
		User user = new User()
		bindData(user, co.properties, [exclude: ['photo']])
		if (!co.photo.empty) {
			user.photo = co.photo.bytes
		}
		if (user.save(flush: true)) {
			session.user = user
			flash.message = "Welcome, ${user.getName()}"
			redirect(controller: 'user', action: 'index')
		} else {
			List<Resource> topPosts = Resource.getTopPosts()
			List<Resource> recentPosts = Resource.getRecentPosts()
			render(view: '/login/index', model: [user: user, topPosts: topPosts, recentPosts: recentPosts])
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
		if (email) {
			User user = User.findByEmail(email)
			if (user) {
				Long id = user.id
				if (user.isActive) {
					String newPassword = Util.generateRandomPassword() as String
					if (User.executeUpdate('update User set password=:newPswd where id=:id1', [newPswd: newPassword, id1: id]) == 1) {
						EmailDTO emailDTO = new EmailDTO(to: email, model: [newPassword: newPassword], view: "/email/_password", subject: "Link Sharing| New password")
						emailService.sendMail(emailDTO)
						flash.message = "Please check your inbox, '$email' for updated password"
					} else {
						flash.error = "Could not update password in database"
					}
				} else {
					flash.error = "Your account is not active"
				}
			} else {
				flash.error = "$email is not a registered email id"
			}
		} else {
			flash.error = "Please enter an email address"
		}
		redirect(controller: 'login', action: 'index')
	}

	def showUsers(UserSearchCO co) {
		if (session.user.isAdmin) {
			if (co.q) {
				List<User> filteredUsers = User.search(co).list([max: 20, sort: co.sort, order: co.order])
				render(view: 'showUsers', model: [users: filteredUsers])
			} else {
				render(view: 'showUsers', model: [users: User.list()])
			}
		} else {
			redirect(controller: 'user', action: 'index')
		}
	}

	def toggleActive(Long userId) {
//		render "$userId------------"
		User user = User.get(userId)
		boolean newStatus = (!user.isActive)
		if (User.executeUpdate('update User set isActive=:status where id=:id', [status: newStatus, id: userId]) == 1) {
			render "User updated"
		} else {
			render "could not update user"
		}
	}

	def showEditProfile() {
		User user = session.user
		List<Topic> topicsCreated = Topic.findAllByCreatedBy(user)
		render(view: 'editProfile', model: [user: user, topicsCreated: topicsCreated])
	}

	def updateDetails(User newUser) {
		User user = User.get(session.user.id)
		user.firstName = newUser.firstName
		user.lastName = newUser.lastName
		user.userName = newUser.userName
		if (newUser.photo)
			user.photo = newUser.photo
		if (user.save(flush: true)) {
			render("Updated")
			session.user = user
		} else
			render("error updating")
	}

	def changePassword(UpdatePasswordCO co) {

	}

	def validateEmail() {

	}
}
