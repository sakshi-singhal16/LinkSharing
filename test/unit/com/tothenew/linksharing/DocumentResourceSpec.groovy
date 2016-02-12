package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {

    def setup() {
    }


    def "test document resource validation"() {
        given:
        DocumentResource documentResource = new DocumentResource(createdBy: user, topic: topic, description: "desc", filePath: testPath)

        when:
        Boolean receivedResult = documentResource.validate()


        then:
        expectedResult == receivedResult

        where:
        testPath   | topic       | user       | expectedResult
        null       | new Topic() | new User() | false
        ""         | new Topic() | new User() | false
        "/filepath/path/" | new Topic() | new User() | true

    }
}
