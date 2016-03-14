package com.tothenew.linksharing

import grails.transaction.Transactional
import org.codehaus.groovy.tools.shell.util.MessageSource

@Transactional
class EmailService {
	def mailService
//	MessageSource messageSource

	def sendMail(EmailDTO emailDTO) {
		mailService.sendMail {
			to emailDTO.to
			subject emailDTO.subject
//			subject messageSource.getMessage(emailDTO.subject, [].toArray(), Locale.default)
			body(view: emailDTO.view, model: emailDTO.model)
		}
	}
}
