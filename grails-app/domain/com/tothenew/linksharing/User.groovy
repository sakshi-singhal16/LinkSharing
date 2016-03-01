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
	String confirmPassword


	static transients = ['name', 'confirmPassword', 'subscribedTopics']
	static hasMany = [topics: Topic, resources: Resource, subscriptions: Subscription, readingItems: ReadingItem, resourceRatings: ResourceRating]

	static constraints = {
		password blank: false, minSize: 5, nullable: false
		firstName blank: false, nullable: false
		lastName blank: false, nullable: false
		email blank: false, email: true, nullable: false, unique: true
		photo nullable: true
		isActive nullable: true
		isAdmin nullable: true
		confirmPassword bindable: true, nullable: true, validator: { val, obj ->
			if (val) {
				if (val != obj.password)
					return false
			}
		}
	}
	static mapping = {
		photo(sqlType: 'longblob')
		sort id: "desc"
	}

	String getName() {
		[firstName, lastName].findAll { it }.join(' ')
	}


	String toString() {
		"User --> $name"
	}

	List<Topic> getSubscribedTopics() {
		List<Topic> subscribedTopics = Subscription.createCriteria().list {
			projections {
				property('topic')
			}
			eq('user', this)
		}
		subscribedTopics
	}
}