package com.tothenew.linksharing

class DocumentResource extends Resource {

    String filePath

    static constraints = {
        filePath nullable: false
    }

	String toString() {
		"Document Resource --> $filePath"
	}
}
