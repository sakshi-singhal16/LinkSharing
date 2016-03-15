<div class="row">

    <script>
        $(document).ready(function () {
            $(".editTopicIcon").click(function () {
                var topicId = $(this).attr('topicId');
                $("#editForm" + topicId).css({'display': 'block'});
            });
            $(".cancelTopicNameButton").click(function (e) {
                e.preventDefault()
                var topicId = $(this).attr('topicId');
                $("#editForm" + topicId).css({'display': 'none'});
            });
        });

    </script>

    <div class="col-md-1">
        <ls:userImage userId="${topicObj.createdBy.id}" height="64" width="64"/>
    </div>

    <div class="col-md-8 col-md-offset-1">

        <div class="row">
            <div class="col-md-12">
                <a href="${createLink(controller: 'topic', action: 'index', params: [id: topicObj.id])}">
                    ${topicObj.topicName}</a> (${topicObj.visibility})
                <div style="display: none" id="editForm${topicObj.id}">
                    <g:textField name="topicName" id="name${topicObj.id}" value="${topicObj.topicName}"/>
                    <g:hiddenField name="topicId" id="topicId${topicObj.id}" value="${topicObj.id}"/>
                    <button class="saveTopicNameButton btn-primary" topicId="${topicObj.id}">Save</button>
                    <button class="cancelTopicNameButton btn-primary" topicId="${topicObj.id}">Cancel</button>
                </div>

            </div>
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
                    <g:if test="${session.user}">
                        <ls:showSubscribe topicId="${topicObj.id}"/>
                    </g:if>
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
    </div>

    <div class="col-md-12">
        <g:if test="${session.user}">
            <div class="col-md-3">
                <ls:showSeriousness id="${topicObj.id}"/>
            </div>

            <div class="col-md-5 col-md-offset-1">
                <ls:canUpdateTopic class="editTopicIcon" id="${topicObj.id}"/>
            </div>

            <div class="col-md-1">
                <span class="glyphicon glyphicon-envelope" href="#"/>
            </div>
        </g:if>

    </div>
</div>