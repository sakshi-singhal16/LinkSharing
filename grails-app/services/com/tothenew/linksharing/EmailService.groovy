package com.tothenew.linksharing

import grails.transaction.Transactional
import org.codehaus.groovy.tools.shell.util.MessageSource

@Transactional
class EmailService {
	def mailService
	def groovyPageRenderer
//	MessageSource messageSource

	def sendMail(EmailDTO emailDTO) {
		mailService.sendMail {
			to emailDTO.to
			subject emailDTO.subject
//			subject messageSource.getMessage(emailDTO.subject, [].toArray(), Locale.default)
			if (emailDTO.content) {
				html emailDTO.content
			} else {
				body(view: emailDTO.view, model: emailDTO.model)
			}
		}
	}

	def sendUnreadResourcesEmail(User user, List<Resource> unreadResources) {
		EmailDTO emailDTO1 = new EmailDTO(to: user.email, subject: "Unread items",
				content: groovyPageRenderer.render(template: '/email/unreadResources',
						model: [user: user, unreadResources: unreadResources]))
		sendMail(emailDTO1)
	}
}
