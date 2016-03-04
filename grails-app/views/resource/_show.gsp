<div class="row">
    <div class="col-md-1">
        <div class="glyphicon glyphicon-user col-md-1" style="font-size:70px;"></div>
    </div>

    <div class="col-md-9 col-md-offset-2">
        <div class="row">
            ${resourceObj.createdBy.userName}
            <span class="text-muted">@${resourceObj.createdBy.userName}, ${resourceObj.id}</span>
            <span class="text-primary pull-right">${resourceObj.topic.topicName}</span>
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

            <div class="col-md-9 ">
                <a href="#">Mark as read</a>

            </div>
        </div>
    </div>
</div>


%{--<div>--}%
%{--resourceObj information ${resourceObj}--}%
%{--</div>--}%
