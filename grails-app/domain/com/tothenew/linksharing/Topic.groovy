package com.tothenew.linksharing

class Topic {
    String topicName
    User createdBy
    Date dateCreated
    Date lastUpdated
    enum visibility
    {
        PUBLIC, PRIVATE
    }
    static hasMany = [resources: Resource, subscriptions: Subscription]

    static constraints = {
        topicName blank: false, nullable: false, unique: 'createdBy'
        createdBy nullable: false

    }
}
