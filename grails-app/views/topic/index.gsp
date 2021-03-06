<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout">
    <title>Link Sharing | ${topicObj.topicName}</title>
</head>

<body>
<div class="container">
    <div class="col-md-5">
        <div class="row">
            <div class="panel panel-primary">
                <div class="panel-body">

                    <g:render template="show" model="${topicObj}"/>
                    <div class="col-md-4 col-md-offset-4">
                        <div class="row">
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <div class="row">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Subscribed users: "${topicObj.topicName}"
                </div>

                <div class="panel-body">
                    <g:each in="${users}" var="user">
                        <g:set var="userObj" value="${user}"/>
                        <g:render template="/user/show" model="${userObj}"/>
                        <hr/>
                    </g:each>
                </div>
            </div>
        </div>

    </div>

    <div class="col-md-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-5">
                    Posts: "${topicObj.topicName}"
                </div>

                    <div class="col-md-7">
                        <g:form class="form-inline" role="search" controller="resource" action="search">
                        <div class="form-group">
                            <g:field type="text" name="q" class="form-control" placeholder="Search"/>
                            <g:hiddenField name="topicId" value="${topicObj.id}"/>
                            <g:submitButton type="submit" name="search" class="btn btn-primary" value="Search"/>
                        </div>
                    </g:form>
                    </div>
                </div>
            </div>

            <div class="panel-body">
                <g:each in="${posts}" var="post">
                    <g:render template="/resource/show" model="[resourceObj: post]"/>
                    <hr/>
                </g:each>
            </div>
        </div>
    </div>

</div>
</body>
</html>