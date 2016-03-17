<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Link Sharing"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
   %{-- <asset:javascript src="jquery.validate.min.js"/>--}%
    <g:layoutHead/>
</head>

<body>
<g:if test="${session.user}">

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">
                    <div class="text-primary h3">Link Sharing</div>
                </a>
            </div>
            <ul class="navbar navbar-right list list-inline">
                <li>
                    <g:form class="navbar-form navbar-right" role="search" controller="resource" action="search"
                            params="[topicId: null]">
                        <div class="form-group">
                            <g:field type="text" class="form-control" placeholder="Search" name="q"/>
                            <g:submitButton name="search" type="submit" class="btn btn-default" value="Search"/>
                        </div>
                    </g:form>
                </li>

                <li>
                    <span class="fa fa-weixin" style="font-size:20px" data-toggle="modal"
                          data-target="#createTopicModal"
                          title="Create new topic"></span>
                </li>
                <li>
                    <span class="fa fa-link " style="font-size:20px" data-toggle="modal" data-target="#shareLinkModal"
                          title="Create link resource"></span>
                </li>
                <li>
                    <span class="glyphicon glyphicon-envelope" style="font-size:20px" data-toggle="modal"
                          data-target="#inviteModal" title="Invite"></span>
                </li>
                <li>
                    <span class="glyphicon glyphicon-folder-open" style="font-size:20px" data-toggle="modal"
                          data-target="#shareDocumentModal" title="Create document resource"></span>
                </li>

                <li>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true"
                               aria-expanded="false">${session.user.name}
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                            <li>

                                <g:link controller="user" action="showEditProfile"
                                params="[id: session.user.id, visibility: com.tothenew.linksharing.Enums.Visibility.PUBLIC, topicId: 0]">
                                Edit Profile
                                </g:link>
                                <g:if test="${session.user.isAdmin}">
                                    <li><a href="${createLink(controller: 'user', action: 'showUsers')}">Users</a></li>

                                </g:if>
                                <li role="separator" class="divider"></li>
                                <li><a href="${createLink(controller: 'login', action: 'logout')}">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>

    </nav>
    <g:render template="/topic/createTopic"/>
    <g:render template="/topic/inviteToTopic"/>
    <g:render template="/resource/createLinkResource"/>
    <g:render template="/documentResource/create"/>

</g:if>
<g:else>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">

                    <div class="text-primary h3">Link Sharing</div>
                </a>

            </div>

            <div class="navbar">

                <g:form class="navbar-form navbar-right" role="search" controller="resource" action="search"
                        params="[topicId: 0]">
                    <div class="form-group">
                        <g:field type="text" class="form-control" placeholder="Search posts.." name="q"/>
                        <g:submitButton name="search" type="submit" class="btn btn-default" value="Search"/>
                    </div>
                </g:form>
            </div>

        </div>
    </nav>

</g:else>
<div class="container">

    <div class="jsonResponse" style="display:none"></div>

    <div class="row">
        <g:if test="${flash.message}">

            <div class="col-xs-12 alert alert-success">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <label><%=flash.message%></label>
            </div>
        </g:if>
    </div>

    <div class="row">
        <g:if test="${flash.error}">
            <div class="col-xs-12 alert alert-danger">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <label><%=flash.error%></label>
            </div>
        </g:if>
    </div>

    <g:layoutBody/>
</div>

</body>
</html>