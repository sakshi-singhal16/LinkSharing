package com.tothenew.linksharing

import org.springframework.web.multipart.MultipartFile

class DocumentResourceController extends ResourceController {

	def save(DocumentResource documentResource) {
		UUID fileName = UUID.randomUUID()
		String path = "/home/sakshi/${grailsApplication.config.linksharing.documents.folderPath}/${fileName}"
		documentResource.filePath = path
		documentResource.createdBy = session.user

		MultipartFile myFile = params.docResource
		File file = new File(path)
		documentResource.contentType = myFile.contentType
		documentResource.validate()
		if (documentResource.errors.getFieldError('contentType')) {
			render "file is not a pdf<br/> ${documentResource.errors.allErrors}"
		} else {
			myFile.transferTo(file)
			render "Done uploading!!!------------------<br/>"

			if (documentResource.save()) {
				flash.message = "$documentResource saved"
				addToReadingItems(documentResource.id)
				render(flash.message)
			} else {
				flash.error = "could not save document resource"
				redirect(controller: 'user', action: 'index')
			}
		}
	}

	def download(Long resourceId){
		Resource resource=Resource.get(resourceId)
		if(resource){
			if(resource.canBeViewedBy(session.user)){
				File file = new File("${resource.filePath}")
				byte[] orderPDF = file.getBytes()
				response.setHeader("Content-disposition", "attachment; filename=" + file.name)
				response.contentLength = orderPDF.length
				response.outputStream << orderPDF
			}
			else {
				render "You are not authorised to download this resource"
			}
		}else {
			render "Resource not found!!"
		}
	}

	def delete(Long resourceId) {
		Resource documentResource = Resource.get(resourceId)
		File file = new File("${documentResource.filePath}")
		if (file.delete()) {
			render "File successfully deleted!"
		} else {
			render("error deleting file!")
		}
	}
}