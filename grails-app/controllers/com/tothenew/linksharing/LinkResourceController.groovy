package com.tothenew.linksharing

import com.tothenew.linksharing.CO.LinkResourceCO

class LinkResourceController extends ResourceController {


	def save(LinkResourceCO linkResourceCO) {
		if (linkResourceCO.topicId && linkResourceCO.url && linkResourceCO.description) {
			Topic topic = Topic.get(linkResourceCO.topicId)
			Resource linkResource = new LinkResource(url: linkResourceCO.url, description: linkResourceCO.description, topic: topic, createdBy: session.user)
			if (linkResource.validate()) {
				if (linkResource.save(flush: true)) {
					flash.message = "New link resource saved"
//					render(flash.message)
					addToReadingItems(linkResource.id)
				} else {
					flash.error = "Could not save link resource"
//					redirect(controller: 'user', action: 'index')
				}
			} else {
//				render("error validating link resource ${linkResource.errors.allErrors}")
//				flash.error="Error validating"
				linkResource.errors.allErrors.each {
					flash.error = "${g.message(error: it)}"
				}
			}
		} else {
			flash.error = "Please provide complete details of the resource"
		}
		redirect(url: request.getHeader('referer'))
	}

	def delete(Long resourceId) {
		render "in link resource delete"
		Resource resource = Resource.get(resourceId)
		try {
			resource.delete(flush: true)
			render "resource deleted"
		}
		catch (Exception e) {
			log.error "Error: ${e.message}"
		}
	}
}
