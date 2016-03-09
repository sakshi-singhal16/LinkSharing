package com.tothenew.linksharing


class ReadingItemController {

	def changeIsRead(Long resourceId, Boolean isRead) {

		Resource resource=Resource.get(resourceId)
		if (ReadingItem.executeUpdate("update ReadingItem set isRead=:flag where resource=:resourceObj",
				[flag: isRead, resourceObj:resource]) == 1) {
//			render (view: 'markIsRead', model: [id: readingItemId, isRead: isRead])
			render "update successful, resource id $resourceId"
		} else
			render "could not update"
		//render "updated $resourceId, $isRead"
	}
}
