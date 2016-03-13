<div class="row">

    <div class="col-md-1">
        <ls:userImage userId="${topicObj.createdBy.id}" height="64" width="64"/>
    </div>

    <div class="col-md-8 col-md-offset-1">

        <div class="row">
            <div class="col-md-12">
                <a href="${createLink(controller: 'topic', action: 'index', params: [id: topicObj.id])}">
                    ${topicObj.topicName}</a> (${topicObj.visibility})
                <div style="display: none" id="editTopicForm">
                    <g:form controller="topic" action="save">
                        <g:field name="topicName" type="text"/>
                        <g:submitButton name="save" value="Save"/>
                        <g:submitButton name="cancelButton" value="Cancel"/>
                    </g:form>
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
                <ls:canUpdateTopic id="${topicObj.id}"/>
            </div>

            <div class="col-md-1">
                <span class="glyphicon glyphicon-envelope" href="#"/>
            </div>
        </g:if>

    </div>
</div>