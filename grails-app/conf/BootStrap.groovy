class BootStrap {
    def grailsApplication
    def init = { servletContext -> println "Changed value: ${grailsApplication.config.grails.var}"
    }
    def destroy = {
    }
}
