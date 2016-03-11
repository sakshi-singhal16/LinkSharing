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
            <div class="panel-info">
                <div class="panel-body" style="border: solid 2px">

                    <g:render template="show" model="${topicObj}"/>
                    <div class="col-md-4 col-md-offset-4">
                        <div class="row">
                            %{--<g:select from="${com.tothenew.linksharing.Enums.Seriousness.values()}" name="seriousness"/>--}%
                            %{--<a hr="#" class="glyphicon glyphicon-envelope"></a>--}%
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <div class="row">
            <div class="panel-primary">
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
        <div class="panel-primary">
            <div class="panel-heading">
                <div class="col-md-3">
                    Posts: "${topicObj.topicName}"
                </div>

                <div class="col-md-7 col-md-offset-2">
                    <g:form class="navbar-form" role="search" controller="resource" action="search">
                        <div class="form-group">
                            <g:field type="text" name="q" class="form-control" placeholder="Search"/>
                            <g:hiddenField name="topicId" value="${topicObj.id}"/>
                            <g:submitButton type="submit" name="search" class="btn btn-primary" value="Search"/>
                        </div>
                    </g:form>
                </div>
            </div>

            <div class="panel-body">
                <g:each in="${posts}" var="post">
                    <g:set var="resourceObj" value="${post}"/>
                    <g:render template="/resource/show" model="${resourceObj}"/>
                    <hr/>
                </g:each>
            </div>
        </div>
    </div>

</div>
</body>
</html>