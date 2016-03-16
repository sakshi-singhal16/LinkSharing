package com.tothenew.linksharing

class ApplicationFilters {

	def filters = {
		all(controller: '*', action: '*') {
			before = {
				log.info("In filter: ${params}")
			}
		}
		/*sessionCheck(controller: '*', action: 'save|delete|update|updateDetails') {
			before = {
				if (!session.user)
					redirect(controller: 'login', action: 'index')
			}
		}*/
		userIndex(controller: 'user', action: 'index', controllerExclude: 'console') {
			before = {
				if (!session.user) {
					redirect(controller: 'login', action: 'index')
					false
				}
			}
		}
		consoleCheck(controller: 'console', action: '*') {
			before = {
				if (!session.user.isAdmin) {
					redirect(controller: 'user', action: 'index')
				}
			}
		}
	}
}
