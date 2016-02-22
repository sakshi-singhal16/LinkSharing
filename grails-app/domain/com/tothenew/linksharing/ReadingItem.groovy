package com.tothenew.linksharing

class ReadingItem {

    Boolean isRead
    Date dateCreated
    Date lastUpdated
    static belongsTo = [user: User, resource: Resource]


    static constraints = {
        resource nullable: false//, unique: 'user'
        user nullable: false
        isRead nullable: false
    }
}
