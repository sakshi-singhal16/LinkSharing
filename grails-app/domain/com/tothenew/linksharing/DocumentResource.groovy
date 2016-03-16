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
		"$filePath"
	}

	String getFileName() {
		filePath.substring(filePath.lastIndexOf('/')
		)
	}

	@Override
	String deleteFile() {
		super.deleteFile()
		File file = new File("${this.filePath}")
		if (file.delete()) {
			"file deleted successfully"
		} else {
			"error deleting file"
		}

	}
	\
}
