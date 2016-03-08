<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout">
    <title>Link Sharing | Post</title>
</head>

<body>
<div class="container">
    <div class="col-md-7">
        <div class="panel-primary">
            <div class="panel-heading"></div>

            <div class="panel-body">
                <div class="col-md-2">
                    <div class="glyphicon glyphicon-user" style="font-size:70px;"></div>
                </div>

                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-3">${resource.createdBy.getName()}</div>

                        <div class="col-md-3 col-md-offset-6">
                            <a href="${createLink(controller: 'topic', action: 'index', params: [id: resource.topic.id])}">
                                ${resource.topic.topicName}
                            </a>
                        </div>
                    </div>

                    <div class="row text-muted">
                        <div class="col-md-3">@${resource.createdBy.userName}</div>

                        <div class="col-md-5 col-md-offset-3">
                            ${resource.lastUpdated}
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-3 col-md-offset-6">
                            <g:form controller="resourceRating" action="save"
                                    params="[resourceId: resource.id]">
                                <g:select from="${1..5}" name="rating" value="${session.user.getScore(resource.id)}"/>
                                <g:submitButton name="rating" value="Submit"/>
                            </g:form>
                        </div>

                    </div>
                </div>

                <div class="row">
                    ${resource.description}
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <span class="fa fa-facebook-square"></span>
                        <span class="fa fa-twitter-square"></span>
                        <span class="fa fa-google-plus-square"></span>
                    </div>

                    <div class="col-md-6 col-md-offset-3 ">
                        <ls:canDeleteResource userId="${session.user.id}" resourceId="${resource.id}"/>
                        <a href="#">Edit ||</a>
                        <a href="#">Download ||</a>
                        <a href="#">View full site ||</a>
                    </div>
                </div>

            </div>
        </div>

    </div>

    <div class="col-md-4">
        <div class="panel-primary" style="margin-top: 20px">
            <div class="panel-heading">
                Trending Topics
            </div>

            <div class="panel-body">
                <g:each in="${trendingTopics}" var="topic">
                    <g:set var="topicObj" value="${topic}"/>
                    <g:render template="/topic/show" model="${topicObj}"/>
                </g:each>
            </div>
        </div>

    </div>
</div>
</body>
</html>