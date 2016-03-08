<div class="row">
    <div class="col-md-1">
        <ls:userImage userId="${resourceObj.createdBy.id}" height="64" width="64"/>
    </div>

    <div class="col-md-9 col-md-offset-2">
        <div class="row">
            <div class="col-md-5">
                ${resourceObj.createdBy.getName()}
                <span class="text-muted">@${resourceObj.createdBy.userName}, ${resourceObj.id}</span>
            </div>

            <div class="col-md-4 col-md-offset-3">
                <a class="text-primary"
                   href="${createLink(controller: 'topic', action: 'index', params: [id: resourceObj.topic.id])}">
                    ${resourceObj.topic.topicName}
                </a>
            </div>
        </div>

        <div class="row">
            <div>${resourceObj.description}</div>
        </div>

        <div class="row">
            <div class="col-md-3">
                <span class="fa fa-facebook-square"></span>
                <span class="fa fa-twitter-square"></span>
                <span class="fa fa-google-plus-square"></span>
            </div>

            <div class="col-md-4  col-md-offset-5">
                %{--<a href="#">Mark as read</a>--}%
                <ls:showResourceTags id="${resourceObj.id}"/>
            </div>
        </div>
    </div>
</div>