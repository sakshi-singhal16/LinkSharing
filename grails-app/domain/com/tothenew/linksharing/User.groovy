package com.tothenew.linksharing

import com.tothenew.linksharing.CO.UserSearchCO
import com.tothenew.linksharing.Enums.Seriousness
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class User {

	String userName
	String password
	String firstName
	String lastName
	String email
	byte[] photo
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
					["com.tothenew.linksharing.User.confirmPassword.matches.password"]
			}
		}
	}
	static mapping = {
		photo(sqlType: 'longblob')
		sort id: "desc"
	}

	static namedQueries = {
		search { UserSearchCO co ->
			if (co.q) {

				ilike('firstName', "%${co.q}%")
				ilike('lastName', "%${co.q}%")
				ilike('userName', "%${co.q}%")
				ilike('email', "%${co.q}%")

			}
			if (co.isActive != null) {
				eq('isActive', co.isActive)
			}
			eq('isAdmin', false)
		}
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
			eq('isRead', false)
		}
		readingItems
	}

	boolean canDeleteResource(Long resourceId) {
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
		ResourceRating resourceRating = ResourceRating.findByUserAndResource(this, Resource.get(resourceId))
		if (resourceRating) {
			resourceRating.rating
		} else {
			0
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