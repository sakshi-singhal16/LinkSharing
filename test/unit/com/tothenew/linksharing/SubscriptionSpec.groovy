package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Subscription)
class SubscriptionSpec extends Specification {

    Subscription subscription

    def setup() {
        subscription = new Subscription()
    }


    @Unroll("Executing #sno")
    def "test subscritpion validations"() {
        given:
        subscription.topic = testTopic
        subscription.user = testUser
        subscription.seriousness = seriousness

        when:
        Boolean receivedResult = subscription.validate()


        then:
        receivedResult == expectedResult

        where:
        sno | testTopic   | testUser   | seriousness        | expectedResult
        1   | null        | new User() | Seriousness.CASUAL | false
        3   | new Topic() | null       | Seriousness.CASUAL | false
        4   | new Topic() | new User() | null               | false
        5   | new Topic() | new User() | Seriousness.CASUAL | true


    }

}
