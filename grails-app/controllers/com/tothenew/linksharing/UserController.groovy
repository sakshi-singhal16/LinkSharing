package com.tothenew.linksharing

import com.tothenew.linksharing.VO.TopicVO

class UserController {
	def assetResourceLocator

	def index() {
		List<Topic> subscribedTopics = session.user.getSubscribedTopics()
		List<TopicVO> trendingTopics = Topic.getTrendingTopics()
		List<ReadingItem> readingItems = session.user.getReadingItems()
		User user = session.user
		render(view: "index",
				model: [subscribedTopics: subscribedTopics, userObj: user, trendingTopics: trendingTopics, readingItems: readingItems])
	}

	def image(Long id) {
		User user = User.get(id)
		byte[] image
//		assetResourceLocator.findAssetForURI('user.png')
		if (!user.photo) {
			image = assetResourceLocator.findAssetForURI('user.png').byteArray
		} else {
			image = user.photo
		}
		OutputStream out = response.getOutputStream()
		out.write(image)
		out.flush()
		out.close()
	}
}
