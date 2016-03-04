<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout">
    <title></title>
</head>

<body>
<div class="container">
    <div class="col-md-6">
        <div class="panel panel-info">
            <div class="panel-heading">Recent Shares</div>

            <div class="panel-body">
                <g:each in="${recentPosts}" var="resource">
                    <g:set var="resourceObj" value="${resource}" scope="request"/>
                    <g:render template="/resource/show" model="${resourceObj}"/>
                %{--${resource}--}%
                </g:each>
            </div>
        </div>

        <div class="panel panel-info">
            <div class="panel-heading">Top Posts
                <div class="dropdown" style="float:right">
                    <g:select from="${["Today", "1 week", "1 month", "1 year"]}" name="time"/>
                </div>
            </div>

            <div class="panel-body">
                <g:each in="${topPosts}" var="resource">
                    <g:set var="resourceObj" value="${resource}" scope="request"/>
                    <g:render template="/resource/show" model="${resourceObj}"/>
                </g:each>
            </div>
        </div>

    </div>

    <div class="col-md-6">
        <g:render template="/login/login"/>
        <g:render template="register"/>
    </div>
    </div>
</body>
</html>