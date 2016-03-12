package com.tothenew.linksharing

import com.sun.xml.internal.bind.v2.TODO

class ReadingItem {

    User user
    //TODO : REMOVE READER OBJECT
    User reader
    Boolean isRead
    Date dateCreated
    Date lastUpdated
    static belongsTo = [resource: Resource]


    static constraints = {
        resource nullable: false, unique: 'user'
        reader nullable: true
        isRead nullable: false
    }

    String toString() {
        "Reading Item --> $reader for $resource"
    }
}
