package com.tothenew.linksharing

import grails.transaction.Transactional

import javax.annotation.Resources

@Transactional
class UserService {
def emailService
	def sendUnreadItemsEmail() {
		getUsersWithUnreadItems().each {user ->

			emailService.sendUnreadResourcesEmail(user, getUnreadResources(user))
		}
	}
	List<User> getUsersWithUnreadItems(){
		return Resource.getUsersWithUnreadResources()
	}
	List<Resource> getUnreadResources(User user){
		return user.unreadResources()
	}
}
