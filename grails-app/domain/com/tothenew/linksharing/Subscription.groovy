package com.tothenew.linksharing

import com.tothenew.linksharing.Enums.Seriousness

class Subscription {
    Topic topic
    User user
    Date dateCreated
    Date lastUpdated

    Seriousness seriousness

    static belongsTo = [user: User, topic: Topic]
    static constraints = {
        topic nullable: false, unique: 'user'
        user nullable: false


    }
}
