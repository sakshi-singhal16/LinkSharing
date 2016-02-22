import com.tothenew.linksharing.Constants.Constants
import com.tothenew.linksharing.DocumentResource

import com.tothenew.linksharing.LinkResource
import com.tothenew.linksharing.ReadingItem
import com.tothenew.linksharing.Resource
import com.tothenew.linksharing.ResourceRating
import com.tothenew.linksharing.Subscription
import com.tothenew.linksharing.Topic
import com.tothenew.linksharing.User

import javax.xml.bind.ValidationException

class BootStrap {
	def grailsApplication
	def init = { servletContext -> //println "Changed value: ${grailsApplication.config.grails.var}"
		List<User> users = createUserAndAdmin()
		List<Topic> topics = createTopics(users)
		List<Resource> resources = createResources(topics)
		subscribeTopics(users, topics)
		List<ReadingItem> readingItems = createReadingItems(users, topics)
		createResourceRatings(readingItems)
	}

	List<User> createUserAndAdmin() {
		if (User.count() == 0) {

			List<User> list = []
			User user = new User(firstName: "test", lastName: "user", userName: "tuser", password: Constants.DEFAULT_PASSWORD,
					email: "test@test.com", isAdmin: false, isActive: true, confirmPassword: Constants.DEFAULT_PASSWORD)

			User admin = new User(firstName: "test", lastName: "admin", userName: "tadmin", password: Constants.DEFAULT_PASSWORD,
					email: "admin@test.com", isAdmin: true, isActive: false)
			list.add(user)
			list.add(admin)

			list.each {
				try {
					if (it.save(flush: true, failOnError: true))
						log.info "user ${it.id} saved successfully"
				}
				catch (ValidationException e) {
					log.error "Error in saving user object ${it.id}: ${e.message}"
				}
				list
			}

		} else {
			log.error("User table not empty")
			User.list()
		}

	}

	List<Topic> createTopics(List<User> users) {
		if (Topic.count() == 0) {
			List<Topic> topics = []
			users.each { User user ->
				1.upto(5) {
					Topic topic = new Topic(topicName: "U${user.id}Topic${it}", visibility: Visibility.PUBLIC, createdBy: user)
					topics.add(topic)
					if (topic.save())
						log.info "---------$topic added for $user--------\n"
					else
						log.error("error creating $topic for user $user")
				}
			}
			topics
		} else {
			log.error("Topic table not empty")
			Topic.list()
		}
	}

	List<Resource> createResources(List<Topic> topics) {

		if (Resource.count() == 0) {
			List<Resource> resources = []
			topics.each { Topic topic ->
				2.times {
					Resource documentResource = new DocumentResource(createdBy: topic.createdBy, topic: topic,
							description: "doc$it description of ${topic.topicName} ", filePath: "path/a/b")
					Resource linkResource = new LinkResource(createdBy: topic.createdBy, topic: topic,
							description: "link$it description of${topic.topicName} ", url: "http://www.google.com")

					resources.add(documentResource)
					resources.add(linkResource)
					if (documentResource.save(flush: true))
						log.info("$documentResource added for $topic")
					else
						log.error("error saving doc $it resource")

					if (linkResource.save(flush: true))
						log.info("$linkResource added for $topic")
					else
						log.error("error saving link $it resource")
				}

			}
			resources
		} else {
			log.error("Resource table not empty")
			Resource.list()
		}
	}

	void subscribeTopics(List<User> users, List<Topic> topics) {
		topics.each { Topic topic ->
			users.each {
				Subscription subscription1 = Subscription.findByTopicAndUser(topic, it)
				if (!subscription1) {
					if (topic.createdBy != it) {
						Subscription subscription = new Subscription(topic: topic, user: it, seriousness: Seriousness.VERY_SERIOUS)
						if (subscription.save())
							log.info("-----Subscription added for $topic for user $it")
					}
				} else {
					log.error("Subscription for $topic already exists for $it")
				}
			}
		}
	}

	List<ReadingItem> createReadingItems(users, topics) {
		List<ReadingItem> readingItems = []
		users.each { User user ->
			topics.each { Topic topic ->
				if (Subscription.findByTopicAndUser(topic, user)) {
					List<Resource> resources1 = Resource.findAllByTopicAndCreatedByNotEqual(topic, user)
					resources1.each { Resource resource ->
						ReadingItem readingItem = new ReadingItem(user: user, resource: resource, isRead: false)
						if (readingItem.save()) {
							readingItems.add(readingItem)
							log.info("********** $user has reading item -- ${resource.id}")
						} else
							log.error("!!!Error saving $user reading item -- ${resource.id}")

					}

				}
			}
		}
		readingItems
	}

	void createResourceRatings(List<ReadingItem> readingItems) {
		readingItems.each {
			if (it.isRead == false) {
				ResourceRating resourceRating = new ResourceRating(resource: it.resource, user: it.user, rating: 3)
				resourceRating.save()
			}
		}
	}
	def destroy = {
	}
}
