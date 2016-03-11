import com.tothenew.linksharing.Constants.Constants
import com.tothenew.linksharing.DocumentResource
import com.tothenew.linksharing.Enums.Seriousness
import com.tothenew.linksharing.Enums.Visibility
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

		if (!User.findByFirstName("Pawan")) {

			List<User> users = createUserAndAdmin()
			List<Topic> topics = createTopics(users)
			List<Resource> resources = createResources(topics)


			subscribeTopics(users, topics)
//			List<ReadingItem> readingItems = createReadingItems(users, topics)
//			createResourceRatings(readingItems)
		}
	}

	List<User> createUserAndAdmin() {
		if (User.count() == 0) {

			List<User> list = []
			User user = new User(firstName: "Pawan", lastName: "Kumar", userName: "pk", password: Constants.DEFAULT_PASSWORD,
					email: "pk@test.com", isAdmin: false, isActive: true, confirmPassword: Constants.DEFAULT_PASSWORD)

			User admin = new User(firstName: "Nisha", lastName: "Gupta", userName: "ng", password: Constants.DEFAULT_PASSWORD,
					email: "ng@test.com", isAdmin: true, isActive: true)
			list.add(user)
			list.add(admin)

			list.each {
				try {
					it.save(flush: true, failOnError: true)
					log.info "user ${it.id} saved successfully"
				}
				catch (ValidationException e) {
					log.error "Error in saving user object ${it}: ${e.message}"
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
					Topic topic = new Topic(topicName: "User${user.id}Topic${it}", createdBy: user, visibility: Visibility.PUBLIC)
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
							description: "This is document$it under ${topic.topicName}. It also has some description about it.",
							filePath: "home/dir/file")
					Resource linkResource = new LinkResource(createdBy: topic.createdBy, topic: topic,
							description: "This is link$it under ${topic.topicName}. It also has some description about it.",
							url: "http://www.google.com")

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
						ReadingItem readingItem = new ReadingItem(reader: user, resource: resource, isRead: false)
						if (readingItem.save(flush: true)) {
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
