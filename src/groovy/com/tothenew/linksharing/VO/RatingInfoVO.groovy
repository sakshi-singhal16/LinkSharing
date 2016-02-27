package com.tothenew.linksharing.VO

/**
 * Created by sakshi on 24/2/16.
 */
class RatingInfoVO {
	Integer totalVotes
	Integer avgScore
	Integer totalScore

	String toString() {
		"total votes: $totalVotes, total score: $totalScore, avg score: $avgScore"
	}
}
