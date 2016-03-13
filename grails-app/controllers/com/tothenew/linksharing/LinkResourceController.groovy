package com.tothenew.linksharing

import com.tothenew.linksharing.CO.LinkResourceCO

class LinkResourceController extends ResourceController {


	def save(LinkResourceCO linkResourceCO) {
		Topic topic = Topic.get(linkResourceCO.topicId)
		Resource linkResource = new LinkResource(url: linkResourceCO.url, description: linkResourceCO.description, topic: topic, createdBy: session.user)
		if (linkResource.validate()) {
			if (linkResource.save(flush: true)) {
				flash.message = "$linkResource saved"
				render (flash.message)
				addToReadingItems(linkResource.id)
			} else {
				flash.error = "could not save link resouce"
				redirect(controller: 'user', action: 'index')
			}
		} else {
			render("error validating link resource ${linkResource.errors.allErrors}")
		}
	}

	def delete(Long resourceId) {
		render "in link resource delete"
	}
}
