package com.tothenew.linksharing

class UtilController {

    def index() {
        //log.error ("Error in util controller")
        render(grailsApplication.config.grails.var)
    }
}
