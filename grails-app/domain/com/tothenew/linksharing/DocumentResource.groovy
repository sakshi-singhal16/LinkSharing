package com.tothenew.linksharing

import com.tothenew.linksharing.Constants.Constants

class DocumentResource extends Resource {
	String filePath
	String contentType

	static transients = ['contentType', 'fileName']
	static constraints = {
		filePath nullable: false
		contentType matches: Constants.DOCUMENT_CONTENT_TYPE
	}

	String toString() {
		"Document Resource --> $filePath"
	}

	String getFileName() {
		filePath.substring(filePath.lastIndexOf('/')
		)
	}

	def afterInsert() {
		DocumentResource.withNewSession {
			List<User> subscribedUsers = this.topic.getSubscribedUsers()
			subscribedUsers.each {

				ReadingItem readingItem = new ReadingItem(isRead: false, user: it, resource: this)
				if (it == this.createdBy) {
					readingItem.isRead = true
				}
				readingItem.save(flush: true)
				log.info("--------${readingItem} saved!!!!!!!!!!!!")
			}
		}
	}
}
