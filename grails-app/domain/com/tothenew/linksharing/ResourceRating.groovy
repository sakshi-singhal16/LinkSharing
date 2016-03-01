package com.tothenew.linksharing

class ResourceRating {

    int rating
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, resource: Resource]

    static constraints = {
        resource nullable: false, unique: 'user'
        user nullable: false
        rating range: 1..5
    }

}
