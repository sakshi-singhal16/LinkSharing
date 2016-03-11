package com.tothenew.linksharing

class ApplicationFilters {

	def filters = {
		all(controller: '*', action: '*') {
			before = {
				log.info("In filter: ${params}")

			}
			after = { Map model ->

			}
			afterView = { Exception e ->

			}
		}
		sessionCheck(controller: '*', controllerExclude: 'login|console|topic|util') {
			before = {
//				if (!session.user)
//					redirect(controller: 'login', action: 'index')

			}
			after = { Map model ->

			}
			afterView = { Exception e ->

			}

		}
	}
}
