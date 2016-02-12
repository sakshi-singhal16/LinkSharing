package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Visibility

class Topic {
    String topicName
    User createdBy
    Date dateCreated
    Date lastUpdated

    Visibility visibility

    static hasMany = [resources: Resource, subscriptions: Subscription]

    static constraints = {
        topicName blank: false, nullable: false, unique: 'createdBy'
        createdBy nullable: false

    }
}
