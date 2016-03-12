<div class="row">
    <div class="col-md-1">
        <ls:userImage userId="${readingItemObj.user.id}" height="64" width="64"/>
    </div>

    <div class="col-md-9 col-md-offset-1">
        <div class="row">
            <div class="col-md-6">
                <span>${readingItemObj.user.getName()}</span>
                <span class="text-muted">@${readingItemObj.user.userName}, res id: ${readingItemObj.resource.id}</span>
            </div>
            <a class="text-primary col-md-3 col-md-offset-3"
               href="${createLink(controller: 'topic', action: 'index', params: [id: readingItemObj.resource.topic.id])}">
                ${readingItemObj.resource.topic.topicName}
            </a>
        </div>

        <div class="row">
            <div>${readingItemObj.resource.description}</div>
        </div>

        <div class="row">
            <div class="col-md-2">
                <span class="fa fa-facebook-square"></span>
                <span class="fa fa-twitter-square"></span>
                <span class="fa fa-google-plus-square"></span>
            </div>

            <div class="col-md-8 col-md-offset-2 ">
                <ls:showResourceTags id="${readingItemObj.resource.id}"/>
                <ls:markAsRead isRead="${readingItemObj.isRead}" user="${session.user}"
                               id="${readingItemObj.resource.id}"/>
                <a href="${createLink(controller: 'resource', action: 'showPostPage', params: [id: readingItemObj.resource.id])}">
                    View Post</a>

            </div>
        </div>
    </div>
</div>