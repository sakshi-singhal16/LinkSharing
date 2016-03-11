package com.tothenew.linksharing

class ReadingItem {

    User user
    User reader
    Boolean isRead
    Date dateCreated
    Date lastUpdated
    static belongsTo = [resource: Resource]


    static constraints = {
//        resource nullable: false, unique: 'user'
//        user(unique: 'resource')
        reader nullable: true
        isRead nullable: false
//        user nullable: true
    }

    String toString() {
        "Reading Item --> $reader for $resource"
    }
}
