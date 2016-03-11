package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness


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


	static transients = ['name', 'confirmPassword', 'subscribedTopics', 'readingItems', 'score']
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
					g.message('com.tothenew.linksharing.User.confirmPassword.matches.password')
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

	List<ReadingItem> getReadingItems() {
		List<ReadingItem> readingItems = ReadingItem.createCriteria().list {

			eq('user', this)
		}
		readingItems
	}

	Boolean canDeleteResource(Long resourceId) {
		Resource resource = Resource.get(resourceId)
		if (resource.createdBy == this || this.isAdmin)
			true
		else
			false

	}

	Boolean isSubscribed(Long topicId) {
		Subscription result = Subscription.createCriteria().get {
			eq('user', this)
			'topic' {
				eq('id', topicId)
			}
		}
		if (result)
			true
		else
			false
	}

	int getScore(Long resourceId) {
		int rating = ResourceRating.createCriteria().get {
			projections {
				property('rating')
			}
			eq('user', this)
			'resource' {
				eq('id', resourceId)
			}
		}
	}

	Seriousness getSubscription(Topic topic) {
		Subscription subscription = Subscription.findByTopic(topic)
		subscription.seriousness
	}


	boolean equals(User user) {
		(this.id == user.id)
	}
}