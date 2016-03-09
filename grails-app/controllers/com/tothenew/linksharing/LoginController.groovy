package com.tothenew.linksharing

class LoginController {

	def index() {
		if (session.user) {
			forward(controller: 'User', action: 'index')
		} else {
			List<Resource> topPosts = Resource.getTopPosts()
			List<Resource> recentPosts = Resource.getRecentPosts()
			/*render (topPosts)
			render ("<br/>")
			render (recentPosts)*/
			render(view: 'index', model: [topPosts: topPosts, recentPosts: recentPosts])
		}
	}

	def login(String userName, String password) {
		User user = User.findByUserNameAndPassword(userName, password)
		if (user) {
			if (user.isActive) {
				session.user = user
				redirect(controller: 'user', action: 'index')
			} else
				flash.message = "Your account is not active"
		} else {
			flash.message = "User not found"
			render(flash.message)
		}
	}

	def register(User user) {
		user.isActive = true
		user.isAdmin = false
		if (user.save(flush: true)) {
			session.user = user
			redirect(controller: 'user', action: 'index')
		} else {
			render("Could not save user")
		}
	}

	def logout() {
		session.invalidate()
		forward(controller: 'login', action: 'index')
	}

def tryTaglib(){
//	render "taglib"
}
}