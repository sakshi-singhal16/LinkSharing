package com.tothenew.linksharing

class ApplicationFilters {

	def filters = {
		all(controller: '*', action: '*') {
			before = {
				log.info("In filter: ${params}")
			}
		}
		sessionCheck(controller: '*', action: 'save|delete|update|') {
			before = {
				if (!session.user)
					redirect(controller: 'login', action: 'index')
			}
		}
		userIndex(controller: 'user', action: 'index') {
			before = {
				if (!session.user)
					redirect(controller: 'login', action: 'index')
			}
		}
		consoleCheck(controller: 'console', action: '*') {
			before = {
				if (!session.user) {
					redirect(controller: 'login', action: 'index')
				}
			}
		}
	}
}
