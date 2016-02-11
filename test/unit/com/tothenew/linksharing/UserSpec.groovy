package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    User user


    def setup() {
        user = new User()
    }

    void "test"() {
        expect:
        true
    }

    @Unroll
    def "test user validations"() {
        given:
        User user = new User(firstName: fn,
                lastName: ln, password: pwd, email: em)

        when:
        Boolean result = user.validate()

        then:
        result == expectedResult

        where:
        fn   | ln        | pwd        | em               | expectedResult
        null | "singhal" | "password" | "sakshi@ttn.com" | false


    }

    def cleanup() {
    }

    void "test something"() {
    }
}
