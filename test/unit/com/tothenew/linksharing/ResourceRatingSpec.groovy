package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(ResourceRating)
class ResourceRatingSpec extends Specification {


    void "test"() {
        expect:
        true
    }

    @Unroll("Executing #sno")
    def "test reading item validations"() {
        given:
        ResourceRating resourceRating = new ResourceRating(resource: testResource, user: testUser, rating: testRating)

        when:
        Boolean receivedResult = resourceRating.validate()

        then:
        receivedResult == expectedResult

        where:
        sno | testResource       | testUser   | testRating | expectedResult
        1   | null               | new User() | 1          | false
        2   | new LinkResource() | null       | 1          | false
        3   | new LinkResource() | new User() | -1         | false
        4   | new LinkResource() | new User() | 6          | false
        5   | new LinkResource() | new User() | 5          | true

    }
}
