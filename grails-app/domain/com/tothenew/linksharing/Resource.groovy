package com.tothenew.linksharing

abstract class Resource {


    User createdBy
    String description
    Date dateCreated
    Date lastUpdated

    static hasMany = [readingIntems: ReadingItem, resourceRatings: ResourceRating]
    static belongsTo = [topic: Topic]
    static constraints = {
        topic nullable: false
        createdBy nullable: false
        description blank: false, nullable: false
    }
    static mapping = {
        description(type: 'text')
    }
}
