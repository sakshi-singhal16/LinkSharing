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
                            <g:select from="${com.tothenew.linksharing.Enums.Seriousness.values()}" name="seriousness"/>
                            <a hr="#" class="glyphicon glyphicon-envelope"></a>
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

    <div class="col-md-5 col-md-offset-1">
        <div class="panel-primary">
            <div class="panel-heading">
                Posts: "${topicObj.topicName}"
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <a class="glyphicon glyphicon-search " style="font-size:20px"></a>
                        <input type="text" class="form-control" placeholder="Search">
                        <input type="button" class="btn btn-primary" value="Search">
                    </div>
                </form>
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
</body>
</html>