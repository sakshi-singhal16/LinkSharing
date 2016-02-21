package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {

	def setup() {
	}

	void "test"() {
		expect:
		true
	}

	@Unroll("Executing test no. #sno for document resource validations")
	def "test document resource validation"() {
		given:
		DocumentResource documentResource = new DocumentResource(createdBy: user, topic: topic, description: "desc", filePath: testPath)

		when:
		Boolean receivedResult = documentResource.validate()

		then:
		expectedResult == receivedResult

		where:
		sno | testPath          | topic       | user       | expectedResult
		1   | null              | new Topic() | new User() | false
		2   | ""                | new Topic() | new User() | false
		3   | "/filepath/path/" | new Topic() | new User() | true

	}

	def "Test toString method of DocumentResource class"() {
		given:
		User user = new User()
		Topic topic = new Topic()
		DocumentResource documentResource = new DocumentResource(createdBy: user, topic: topic, description: "desc", filePath: "/a/b/c")

		when:
		String s = "$documentResource"

		then:
		s == "Document Resource --> /a/b/c"

	}
}
