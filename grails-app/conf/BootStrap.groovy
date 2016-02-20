import com.tothenew.linksharing.DocumentResource
import com.tothenew.linksharing.Enums.Visibility
import com.tothenew.linksharing.LinkResource
import com.tothenew.linksharing.Resource
import com.tothenew.linksharing.Subscription
import com.tothenew.linksharing.Topic
import com.tothenew.linksharing.User

import javax.xml.bind.ValidationException

class BootStrap {
	def grailsApplication
	def init = { servletContext -> //println "Changed value: ${grailsApplication.config.grails.var}"
		List<User> users = createUserAndAdmin()
		List<Topic> topics = createTopics(users)
		List<Resource> documentResources = createResources(topics)
		//List<Subscription> subscriptions=subscribeTopics(users, topics)
	}

	List<User> createUserAndAdmin() {
		if (User.count() == 0) {
			List<User> list = []
			User user = new User(firstName: "test", lastName: "user", userName: "tuser", password: "password", email: "test@test.com", isAdmin: false)
			User admin = new User(firstName: "test", lastName: "admin", userName: "tadmin", password: "password", email: "admin@test.com", isAdmin: true)
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
					Topic topic = new Topic(topicName: "Topic${it}", visibility: Visibility.PUBLIC, createdBy: user)
					topics.add(topic)
					if (topic.save())
						log.info "---------${topic.topicName} added for $user--------\n"
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
							description: "doc1 description of ${topic.topicName} ", filePath: "path/a/b")
					Resource linkResource = new LinkResource(createdBy: topic.createdBy, topic: topic,
							description: "link1 description of${topic.topicName} ", url: "http://www.google.com")

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

//	List<Subscription> subscribeTopics(List<User> users, List<Topic> topics )
//	{
//		users.each { User user ->
//			topics.each {
//
//			}
//		}
//	}
	def destroy = {
	}
}
