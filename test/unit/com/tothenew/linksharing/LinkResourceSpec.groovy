package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LinkResource)
class LinkResourceSpec extends Specification {

    def setup() {
    }

    def "test lik resource validations"() {

        given:
        LinkResource linkResource = new LinkResource(createdBy: user, topic: topic, description: "desc", url: testurl)

        when:
        Boolean receivedResult = linkResource.validate()


        then:
        expectedResult == receivedResult

        where:
        testurl                 | topic       | user       | expectedResult
        null                    | new Topic() | new User() | false
        ""                      | new Topic() | new User() | false
        "url"                   | new Topic() | new User() | false
        "http://www.google.com" | new Topic() | new User() | true


    }
}
