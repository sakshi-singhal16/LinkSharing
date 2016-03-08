<div>
    <div class="col-md-3">
        <ls:userImage userId="${userObj?.id}" height="64" width="64"/>
    </div>

    <div class="col-md-8 col-md-offset-1">

        <div class="row">
            <h3>${userObj.getName()}</h3>
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