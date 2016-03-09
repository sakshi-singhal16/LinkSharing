package com.tothenew.linksharing

class OneTagLib {
   /* static defaultEncodeAs = [taglib:'html']*/
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    //static namespace = "ls"

	def showUserList={
		List<User> users=User.list()
		out << render (template: '/util/one', model:[listOfUsers:users])
	}
	def showAdmin={attrs, body->
		Boolean isAdmin= Boolean.valueOf(attrs.isAdmin)
		if(isAdmin)
		{
			out<<body()
		}

	}
}
