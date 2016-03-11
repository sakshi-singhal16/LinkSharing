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
		"Document Resource --> $filePath\n $description"
	}

	String getFileName() {
		filePath.substring(filePath.lastIndexOf('/')
		)
	}


}
