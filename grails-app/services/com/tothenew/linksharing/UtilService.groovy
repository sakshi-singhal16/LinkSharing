package com.tothenew.linksharing

import grails.transaction.Transactional


@Transactional
class UtilService {

    def mailService


    def testUser(){
        User user = new User(firstName: "test", lastName: "user",
                userName: "testuser1", password: "default",email: "tesuser@test.com"
        )
        user.save(flush: true)
        /*if (user.validate()) {
            user.save()
        } else {
            render user.errors.allErrors.collect {
                it //message(error:it )
            }
        }*/
        user.properties
    }

	def email(){
		mailService.sendMail{
			to "shalika.singhal@tothenew.com"
			subject "happy women's day"
			body "chocolate and card and movies :D"
		}
	}
}
