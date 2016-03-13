<div>
    <div class="col-md-1">
        <ls:userImage userId="${userObj?.id}" height="64" width="64"/>
    </div>

    <div class="col-md-9 col-md-offset-2">

        <div class="row">
            <div class="col-md-12">
                <h4><g:link controller="user"
                            action="profile"
                            params="[id: userObj.id, visibility: com.tothenew.linksharing.Enums.Visibility.PUBLIC, topicId: 0]">
                    ${userObj.getName()}
                </g:link>
                </h4>
            </div>

        </div>

        <div class="row">
            <div class="col-md-3 text-muted">
                @${userObj.userName}
            </div>
        </div>

        <div class="row">
            <div class="text-muted">
                <div class="col-md-5">
                    Subscriptions
                </div>

                <div class="col-md-3 col-md-offset-2">
                    Posts
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-5">
                <ls:subscriptionCount userId="${userObj.id}"/>
            </div>

            <div class="col-md-3 col-md-offset-2">
                <ls:topicCount userId="${userObj.id}"/>
            </div>
        </div>

    </div>
</div>