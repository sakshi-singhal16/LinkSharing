package com.tothenew.linksharing

import org.springframework.web.multipart.MultipartFile

class DocumentResourceController extends ResourceController {

	def save(DocumentResource documentResource) {
		if (documentResource.description && documentResource.topic && params.docResource) {
			String path = "/home/sakshi/${grailsApplication.config.linksharing.documents.folderPath}/${UUID.randomUUID()}"
			documentResource.filePath = path
			documentResource.createdBy = session.user

			MultipartFile myFile = params.docResource
			File file = new File(path)
			documentResource.contentType = myFile.contentType
			documentResource.validate()
			def error = documentResource.errors.getFieldError('contentType')
			if (error) {
				flash.error = g.message(error: error)
			} else {
				myFile.transferTo(file)
				flash.message = "File uploaded, "
				if (documentResource.save(flush: true)) {
					addToReadingItems(documentResource.id)
					flash.message += "Document Resource saved"
				} else {
					flash.error = "Could not save document resource"
				}
			}
		} else {
			flash.error = "Please provide complete details"
		}
		redirect(url: request.getHeader('referer'))
	}

	def download(Long resourceId) {
		File file
		Resource resource = Resource.get(resourceId)
		if (resource) {
			if (resource.canBeViewedBy(session.user)) {
				try {
					file = new File("${resource.filePath}")
					byte[] orderPDF = file.getBytes()
					response.setHeader("Content-disposition", "attachment; filename=" + file.name)
					response.contentLength = orderPDF.length
					response.outputStream << orderPDF
				} catch (FileNotFoundException e) {
					render "Error: ${e.message}"
				}

			} else {
				render "You are not authorised to download this resource"
			}
		} else {
			render "Resource not found!!"
		}
	}

	def delete(Long resourceId) {
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