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


        <div class="panel panel-info" style="margin-top: 20px;overflow-y: auto;height: 238px">
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
            </div>
        </div>

        <div class="panel panel-info" style="margin-top: 20px;overflow-y: auto;height: 300px">
            <div class="panel-heading">
                Subscriptions
            </div>

            <div class="panel-body">
                <g:each in="${subscribedTopics}" var="topic">
                    <g:render template="/topic/show" model="[topicObj: topic]"/>
                    <hr/>
                </g:each>

            </div>
        </div>

    </div>

    <div class="col-md-7">
        <div class="panel panel-info" style="overflow-y: auto;height: 500px">

            <div class="panel-heading">Posts
            </div>

            <div class="panel-body">
                <g:each in="${postsCreated}" var="resource">
                    <g:set var="resourceObj" value="${resource}"/>
                    <g:render template="/resource/show" model="${resourceObj}"/>
                    <hr/>
                </g:each>
            </div>
        </div>
    </div>

</div>

</body>
</html>