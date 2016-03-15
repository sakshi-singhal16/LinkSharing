<div class="row">
    <div class="col-md-1">
        <ls:userImage userId="${resourceObj.createdBy.id}" height="64" width="64"/>
    </div>

    <div class="col-md-10 col-md-offset-1">
        <div class="row">
            <div class="col-md-5">
                <g:link controller="user" action="profile"
                        params="[id: resourceObj.createdBy.id, visibility: com.tothenew.linksharing.Enums.Visibility.PUBLIC, topicId: 0]">
                    ${resourceObj.createdBy.getName()}
                </g:link>
                <span class="text-muted">@${resourceObj.createdBy.userName}</span>
            </div>

            <div class="col-md-3 col-md-offset-4">
                <a class="text-primary"
                   href="${createLink(controller: 'topic', action: 'index', params: [id: resourceObj.topic.id])}">
                    ${resourceObj.topic.topicName}
                </a>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">${resourceObj.description}</div>
        </div>

        <div class="row">
            <div class="col-md-3">
                <span class="fa fa-facebook-square"></span>
                <span class="fa fa-twitter-square"></span>
                <span class="fa fa-google-plus-square"></span>
            </div>

            <div class="col-md-3  col-md-offset-6">
                <a href="${createLink(controller: 'resource', action: 'showPostPage', params: [id: resourceObj.id])}">
                    View Post</a>
            </div>
        </div>
    </div>
</div>