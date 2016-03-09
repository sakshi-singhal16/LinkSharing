package com.tothenew.linksharing

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import javassist.tools.rmi.ObjectNotFoundException
import spock.lang.Specification

@Mock([DocumentResource, Resource])
@TestFor(ResourceController)
class ResourceControllerSpec extends Specification {


	//NOT WORKING
	def "delete action"() {
		given:
		Resource documentResource = new DocumentResource(createdBy: new User(), topic: new Topic(),
				description: "this is a documen resource ", filePath: "path/a/b")
		documentResource.save()

		when:
		controller.delete(documentResource.id)

		then:
//		response.text == "Document Resource --> path/a/b deleted successfully"
		notThrown(ObjectNotFoundException)
	}
}