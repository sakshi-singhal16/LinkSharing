<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout"/>
    <title>User Profile | ${userObj.getName()}</title>
</head>

<body>
<div class="container">

    <div class="col-md-5">

        <div class="panel panel-danger">
            <div class="panel-body">
                <g:render template="show" model="${userObj}"/>
            </div>
        </div>


        <div class="panel panel-info" style="margin-top: 20px">
            <div class="panel-heading">
                <div>
                    Topics
                </div>

            </div>

            <div class="panel-body">
                <g:each in="${topicsCreated}" var="topic">
                    <g:render template="/topic/show" model="[topicObj: topic]"/>
                    <hr/>
                </g:each>
                <g:paginate total="20" controller="user" action="profile"
                            params='[id: "${resourceSearchCo.id}", visibility: "${resourceSearchCo.visibility}"]'
                            max="${resourceSearchCo.max}" offset="${resourceSearchCo.offset}"/>
            </div>
        </div>

        <div class="panel panel-info" style="margin-top: 20px">
            <div class="panel-heading">
                Subscriptions
            </div>

            <div class="panel-body">
                <g:each in="${subscribedTopics}" var="topic">
                    <g:render template="/topic/show" model="[topicObj: topic]"/>
                    <hr/>
                </g:each>
                <g:paginate total="20" controller="user" action="profile"
                            params='[id: "${resourceSearchCo.id}", visibility: "${resourceSearchCo.visibility}"]'
                            max="${resourceSearchCo.max}" offset="${resourceSearchCo.offset}"
                            next="Next" prev="Back"/>
            </div>
        </div>

    </div>

    <div class="col-md-7">
        <div class="panel panel-info">

            <div class="panel-heading">Posts
            </div>

            <div class="panel-body">
                <g:each in="${postsCreated}" var="resource">
                    <g:set var="resourceObj" value="${resource}"/>
                    <g:render template="/resource/show" model="${resourceObj}"/>
                    <hr/>
                </g:each>
                <g:paginate total="20" controller="user" action="profile"
                            params='[id: "${resourceSearchCo.id}", visibility: "${resourceSearchCo.visibility}"]'
                            max="${resourceSearchCo.max}" offset="${resourceSearchCo.offset}"/>
            </div>
        </div>
    </div>

</div>

</body>
</html>