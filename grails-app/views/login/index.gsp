<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout">
    <title></title>
</head>

<body>
<div class="container">
    <g:hasErrors bean="${user}">

        <div class="alert alert-danger">
            <ul>Error in registration!
                <g:eachError>
                    <li>
                        <g:message error="${it}"/>
                    </li>
                </g:eachError>
            </ul>
        </div>
    </g:hasErrors>

    <g:if test="${message}">
        <div class="alert alert-warning">
            ${message}
        </div>
    </g:if>

    <div class="col-md-6">

        <div class="panel panel-info">
            <div class="panel-heading">Recent Shares
            </div>

            <div class="panel-body">
                <g:each in="${recentPosts}" var="resource">
                    <g:render template="/resource/show" model="[resourceObj: resource]"/>
                    <hr/>
                </g:each>
            </div>
        </div>

        <ls:showTopPosts posts="${topPosts}"/>

    </div>

    <div class="col-md-6">
        <g:render template="/login/login" bean="${user}"/>
        <g:render template="/login/register"/>
    </div>
</div>
</body>
</html>