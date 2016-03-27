<div class="row">
    <div class="col-md-1">
        <ls:userImage userId="${readingItemObj.resource.createdBy.id}" height="64" width="64"/>
    </div>

    <div class="col-md-9 col-md-offset-1">
        <div class="row">
            <div class="col-md-6">
                <g:link controller="user"
                        action="profile"
                        params="[id: readingItemObj.resource.createdBy.id, visibility: com.tothenew.linksharing.Enums.Visibility.PUBLIC, topicId: 0]">
                    ${readingItemObj.resource.createdBy.getName()}</g:link>
                <span class="text-muted">@${readingItemObj.resource.createdBy.userName}</span>
            </div>
            <a class="text-primary col-md-3 col-md-offset-3"
               href="${createLink(controller: 'topic', action: 'index', params: [id: readingItemObj.resource.topic.id])}">
                ${readingItemObj.resource.topic.topicName}
            </a>
        </div>

        <div class="row">
            <div class="col-md-12">${readingItemObj.resource.description}</div>
        </div>

        <div class="row">
            <div class="col-md-2">
                <a class="fa fa-facebook-square" id="facebook-share" style="font-size: 16px"></a>
                <a class="fa fa-twitter-square" href="https://twitter.com/intent/tweet" style="font-size: 16px"></a>
                <a href="https://plus.google.com/share?url={URL}" onclick="javascript:window.open(this.href,
                        '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
                return false;">
                    <img src="https://www.gstatic.com/images/icons/gplus-16.png" alt="Share on Google+"/></a>
            </div>

            <div class="col-md-8 col-md-offset-2">
                <ls:showResourceTags id="${readingItemObj.resource.id}"/>
                <ls:markAsRead isRead="${readingItemObj.isRead}" user="${session.user}"
                               id="${readingItemObj.resource.id}"/>
                <a href="${createLink(controller: 'resource', action: 'showPostPage', params: [id: readingItemObj.resource.id])}">
                    View Post</a>

            </div>
        </div>
    </div>
</div>