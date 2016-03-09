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
    <g:layoutHead/>
</head>

<body>
<g:if test="${session.user}">
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            %{--<div class="col-md-12">--}%
            <a class="navbar-brand" href="#">

                <div class="text-primary h3">Link Sharing</div>
            </a>
            %{--</div>--}%
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
                <span class="fa fa-weixin" style="font-size:20px" data-toggle="modal" data-target="#createTopicModal"
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${session.user.name}
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Profile</a></li>
                            <li><a href="#">Users</a></li>
                            <li><a href="#">Action</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="${createLink(controller: 'login', action: 'logout')}">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </li>

        </ul>
    </nav>
    <g:render template="/topic/createTopic"/>
    <g:render template="/topic/inviteToTopic"/>
    <g:render template="/resource/createLinkResource"/>
    <g:render template="/documentResource/create"/>

</g:if>
<g:else>
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">

                <div class="text-primary h3">Link Sharing</div>
            </a>

        </div>

        <div class="navbar">

            <g:form class="navbar-form navbar-right" role="search" controller="resource" action="search"
                    params="[topicId: null]">
                <div class="form-group">
                    <g:field type="text" class="form-control" placeholder="Search posts.." name="q"/>
                    <g:submitButton name="search" type="submit" class="btn btn-default" value="Search"/>
                </div>
            </g:form>
        </div>

    </nav>


</g:else>

<g:layoutBody/>

</body>
</html>