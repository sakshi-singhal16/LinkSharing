package com.tothenew.linksharing

class ResourceRating {

    Resource resource
    int rating
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, resourceRating: ResourceRating]

    static constraints = {
        resource nullable: false, unique: 'user'
        user nullable: false
        rating range: 1..5
    }
}
