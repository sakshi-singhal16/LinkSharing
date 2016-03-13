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
			render(view: 'index', model: [user: user, message: "${message(code: "user.account.not.active")}"])
		} else {
			flash.message = "User not found"
//			render(flash.message)
			render(view: 'index', model: [user: user, message: "${message(code: "invalid.user.credentials")}"])

		}
	}


	def logout() {
		session.invalidate()
		forward(controller: 'login', action: 'index')
	}

}