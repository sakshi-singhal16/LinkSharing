package com.tothenew.linksharing

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(User)
class UserSpec extends Specification {

	User user

	void "test"() {
		expect:
		true
	}

	@Unroll("Executing #sno")
	def "test user validations"() {
		given:
		User user = new User(firstName: fn,
				lastName: ln, password: pwd, email: em, userName: uname, confirmPassword: cpwd)

		when:
		Boolean result = user.validate()

		then:
		result == expectedResult

		where:
		sno | fn       | ln        | pwd        | cpwd       | em               | uname | expectedResult
		1   | null     | "singhal" | "password" | "password" | "sakshi@ttn.com" | "ss"  | false
		2   | ""       | "singhal" | "password" | "password" | "sakshi@ttn.com" | "ss"  | false
		3   | "sakshi" | null      | "password" | "password" | "sakshi@ttn.com" | "ss"  | false
		4   | "sakshi" | ""        | "password" | "password" | "sakshi@ttn.com" | "ss"  | false
		5   | "sakshi" | "singhal" | null       | null       | "sakshi@ttn.com" | "ss"  | false
		6   | "sakshi" | "singhal" | ""         | ""         | "sakshi@ttn.com" | "ss"  | false
		7   | "sakshi" | "singhal" | "p"        | "p"        | "sakshi@ttn.com" | "ss"  | false
		8   | "sakshi" | "singhal" | "password" | "password" | null             | "ss"  | false
		9   | "sakshi" | "singhal" | "password" | "password" | ""               | "ss"  | false
		10  | "sakshi" | "singhal" | "password" | "password" | "sakshi@ttn.com" | null  | false
		11  | "sakshi" | "singhal" | "password" | "password" | "sakshi@ttn.com" | ""    | false
		12  | "sakshi" | "singhal" | "password" | "password" | "sakshi@ttn.com" | "ss"  | true
		13  | "sakshi" | "singhal" | "password" | null       | "sakshi@ttn.com" | "ss"  | false
		14  | "sakshi" | "singhal" | "password" | "pw"       | "sakshi@ttn.com" | "ss"  | false
		15  | "sakshi" | "singhal" | "password" | "password" | "sakshi@ttn.com" | "ss"  | true


	}

	def "email id of user should be unique"() {
		given:
		User user = new User(firstName: "sakshi", lastName: "singhal", email: "sakshi@tothenew.com", password: "sakshi", userName: "ss")

		when:
		user.save()


		then:
		user.count() == 1  //count is static method, works on both Class and object

		when:
		User user2 = new User(firstName: "priyanka", lastName: "gupta", email: "sakshi@tothenew.com", password: "sakshi", userName: "pg")
		user2.save()

		then:
		user.count() == 1
		user2.errors.allErrors.size() == 1
		user2.errors.getFieldErrorCount("email") == 1

	}

	@Unroll("Tesing get name method for  #sno")
	def "test get name"() {
		given:
		user.firstName = fn
		user.lastName = ln
		user.email = "abc@ttn.com"
		user.userName = "ss"
		user.password = "password"


		when:
		String receivedResult = user.getName()


		then:
		receivedResult == expectedResult

		where:
		sno | fn       | ln        | expectedResult
		1   | null     | "singhal" | "singhal"
		2   | "sakshi" | null      | "sakshi"
		3   | "sakshi" | "singhal" | "sakshi singhal"

	}


	def "Test toString method of User class"() {
		given:
		user.firstName = "test"
		user.lastName = "user"

		when:
		String s = "hello $user"

		then:
		s == "hello User --> test user"

	}


}
