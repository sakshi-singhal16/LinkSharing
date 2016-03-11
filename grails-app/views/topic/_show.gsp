<div class="row">

    <div>
        <div class="col-md-2">
            <ls:userImage userId="${topicObj.createdBy.id}" height="64" width="64"/>
        </div>

        <div class="col-md-8 col-md-offset-1">

            <div class="row">
                <a href="${createLink(controller: 'topic', action: 'index', params: [id: topicObj.id])}">
                    ${topicObj.topicName}</a> (${topicObj.visibility})
            </div>

            <div class="row">
                <div class="text-muted">
                    <div class="col-md-3">
                        @${topicObj.createdBy.userName}
                    </div>


                    <div class="col-md-4 col-md-offset-1">
                        Subscriptions
                    </div>

                    <div class="col-md-2 col-md-offset-1">
                        Posts
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="text-primary">
                    <div class="col-md-3">
                        %{--<a>Subscribe</a>--}%
                        <ls:showSubscribe topicId="${topicObj.id}"/>
                    </div>

                    <div class="col-md-4 col-md-offset-1">
                        <ls:subscriptionCount topicId="${topicObj.id}"/>
                    </div>

                    <div class="col-md-2 col-md-offset-1">
                        <ls:resourceCount topicId="${topicObj.id}"/>
                    </div>
                </div>
            </div>

        </div>

        <div class="col-md-12">

            %{--<g:if test="${topicObj.createdBy.id != session.user.id}">

                <div class="col-md-3 col-md-offset-1">
                    <g:select name="seriousness" from="${com.tothenew.linksharing.Enums.Seriousness.values()}"/>
                </div>
                <div class="col-md-3 col-md-offset-2">
                    <span class="glyphicon glyphicon-envelope" href="#"/>
                </div>

            </g:if>
            <g:else>
                <div class="col-md-3 col-md-offset-1">
                    <g:select name="seriousness" from="${com.tothenew.linksharing.Enums.Seriousness.values()}"/>
                </div>

                <div class="col-md-3 col-md-offset-1">
                    <g:select name="visibility" from="${com.tothenew.linksharing.Enums.Visibility.values()}"/>
                </div>

                <div class="col-md-3">
                    <span class="glyphicon glyphicon-envelope" href="#"/>
                    <span class="glyphicon glyphicon-edit"/>
                    <span class="glyphicon glyphicon-trash"/>

                </div>--}%
            <div class="col-md-3">
                %{--<g:select name="seriousness" from="${com.tothenew.linksharing.Enums.Seriousness.values()}"/>--}%
                <ls:showSeriousness id="${topicObj.id}"/>
            </div>

            <div class="col-md-5 col-md-offset-1">
                <ls:canUpdateTopic id="${topicObj.id}"/>
            </div>

            <div class="col-md-1">
                <span class="glyphicon glyphicon-envelope" href="#"/>
            </div>

            %{--</g:else>--}%
        </div>
    </div>
</div>