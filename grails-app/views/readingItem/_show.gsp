<div class="row">
    <div class="col-md-1">
        <div class="glyphicon glyphicon-user col-md-1" style="font-size:70px;"></div>
    </div>

    <div class="col-md-9 col-md-offset-2">
        <div class="row">
            ${readingItemObj.user.getName()}
            <span class="text-muted">@${readingItemObj.user.userName}, res id: ${readingItemObj.resource.id}</span>
            <span class="text-primary pull-right">${readingItemObj.resource.topic.topicName}</span>
        </div>

        <div class="row">
            <div>${readingItemObj.resource.description}</div>
        </div>

        <div class="row">
            <div class="col-md-3">
                <span class="fa fa-facebook-square"></span>
                <span class="fa fa-twitter-square"></span>
                <span class="fa fa-google-plus-square"></span>
            </div>

            <div class="col-md-9 ">
                <a href="#">Download ||</a>
                <a href="#">View full site ||</a>
                %{--<a href="#">Mark as read ||</a>--}%
                <ls:markAsRead isRead="${readingItemObj.isRead}" user="${session.user}"
                               id="${readingItemObj.resource.id}"/>
                <a href="#">View Post</a>

            </div>
        </div>
    </div>
</div>


%{--<div>--}%
%{--readingItemObj information ${readingItemObj}--}%
%{--</div>--}%
