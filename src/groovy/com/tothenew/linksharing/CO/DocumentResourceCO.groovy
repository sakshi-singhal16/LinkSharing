package com.tothenew.linksharing.CO

import grails.validation.Validateable

@Validateable
class DocumentResourceCO {
	String filePath
	String description
	Long topicId
}
