package com.tothenew.linksharing

import grails.converters.JSON


class ReadingItemController {

	def changeIsRead(Long resourceId, Boolean isRead) {

		Resource resource=Resource.get(resourceId)
		if (ReadingItem.executeUpdate("update ReadingItem set isRead=:flag where resource=:resourceObj",
				[flag: isRead, resourceObj:resource]) == 1) {
			render([message: 'Status changed successfully'] as JSON)
		} else
			render([error: 'Error while updating status'] as JSON)
	}
}
