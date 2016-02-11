package com.tothenew.linksharing

class Subscription {
    Topic topic
    User user
    Date dateCreated
    Date lastUpdated

    enum seriousness {
        SERIOUS, VERY_SERIOUS, CASUAL
    }

    static belongsTo = [user: User, topic: Topic]
    static constraints = {
        topic nullable: false, unique: 'user'
        user nullable: false


    }
}
