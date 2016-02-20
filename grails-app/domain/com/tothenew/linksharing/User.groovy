package com.tothenew.linksharing

class User {

	String userName
	String password
	String firstName
	String lastName
	String email
	Byte[] photo
	Boolean isAdmin
	Boolean isActive
	Date dateCreated
	Date lastUpdated


	static transients = ['name']
	static hasMany = [topics: Topic, resources: Resource, subscriptions: Subscription, readingItems: ReadingItem, resourceRatings: ResourceRating]

	static constraints = {
		password blank: false, minSize: 5, nullable: false
		firstName blank: false, nullable: false
		lastName blank: false, nullable: false
		email blank: false, email: true, nullable: false, unique: true
		photo nullable: true
		isActive nullable: true
		isAdmin nullable: true

	}
	static mapping = { photo(sqlType: 'longblob') }

	String getName() {
		[firstName, lastName].findAll { it }.join(' ')
	}

	String toString() {
		"User --> $name"
	}
}