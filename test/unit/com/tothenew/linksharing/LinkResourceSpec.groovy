package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(LinkResource)
class LinkResourceSpec extends Specification {

    def setup() {
    }

    void "test"() {
        expect:
        true
    }

    @Unroll("Executing test no. #sno for link resource validations")
    def "test link resource validations"() {

        given:
        LinkResource linkResource = new LinkResource(createdBy: user, topic: topic, description: "desc", url: testurl)

        when:
        Boolean receivedResult = linkResource.validate()


        then:
        expectedResult == receivedResult

        where:
        sno | testurl                 | topic       | user       | expectedResult
        1   | null                    | new Topic() | new User() | false
        2   | ""                      | new Topic() | new User() | false
        3   | "url"                   | new Topic() | new User() | false
        4   | "http://www.google.com" | new Topic() | new User() | true


    }
}
