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
				flash.message = "Welcome, ${user.getName()}"
				redirect(controller: 'user', action: 'index')
			} else {

				flash.error = "Your account is not active"
				render(view: 'index', model: [user: user, topPosts: Resource.getTopPosts(), recentPosts: Resource.getRecentPosts()])
			}
		} else {
			flash.error = "Please enter valid user details"
			render(view: 'index', model: [user: user, topPosts: Resource.getTopPosts(), recentPosts: Resource.getRecentPosts()])

		}
	}


	def logout() {
		session.invalidate()
		flash.message = "You have been successfully logged out"
		forward(controller: 'login', action: 'index')
	}

}