package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Visibility
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Topic)
class TopicSpec extends Specification {
	Topic topic

	def setup() {
		topic = new Topic()
	}

	void "test"() {
		expect:
		true
	}

	@Unroll("Executing test no. #sno for topic validations")
	def "test topic validations"() {
		given:
		topic.topicName = testName
		topic.createdBy = testAuthor
		topic.visibility = visibility

		when:
		Boolean receivedResult = topic.validate()


		then:
		receivedResult == expectedResult

		where:
		sno | testName | testAuthor | visibility         | expectedResult
		1   | null     | new User() | Visibility.PRIVATE | false
		2   | ""       | new User() | Visibility.PRIVATE | false
		3   | "Grails" | null       | Visibility.PRIVATE | false
		4   | "Grails" | new User() | null               | false
		5   | "Grails" | new User() | Visibility.PRIVATE | true


	}

	def "Test toString method of topic class"() {
		given:
		topic.topicName = "Grails"

		when:
		String s = "$topic"

		then:
		s == "Topic --> Grails"

	}
}
