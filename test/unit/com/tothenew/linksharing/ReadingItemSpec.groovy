package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {


    void "test"() {
        expect:
        true
    }

    def "test reading item validations"() {
        given:
        ReadingItem readingItem = new ReadingItem(resource: testResource, user: testUser, isRead: testReadFlag)

        when:
        Boolean receivedResult = readingItem.validate()

        then:
        receivedResult == expectedResult

        where:
        testResource       | testUser   | testReadFlag | expectedResult
        null               | new User() | true         | false
        new LinkResource() | null       | true         | false
        new LinkResource() | new User() | null         | false
        new LinkResource() | new User() | true         | true

    }

}
