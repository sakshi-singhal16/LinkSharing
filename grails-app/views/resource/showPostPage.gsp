<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout">
    <title>Link Sharing | Post</title>
    <script type="text/javascript">
        $(document).ready(function () {
//            alert("hello out")

        });
    </script>
</head>

<body>
<div class="container">

    <div class="col-md-7">
        <div class="panel panel-primary">

            <div class="panel-body">
                <div class="col-md-2">
                    %{--<div class="glyphicon glyphicon-user" style="font-size:70px;"></div>--}%
                    <ls:userImage userId="${resource.createdBy.id}" height="64" width="64"/>
                </div>

                <div class="col-md-10">
                    <div class="row">
                        <g:link controller="user" action="profile"
                                params="[id: resource.createdBy.id, visibility: com.tothenew.linksharing.Enums.Visibility.PUBLIC, topicId: 0]"
                                class="col-md-3">
                            ${resource.createdBy.getName()}</g:link>

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
                            <g:form controller="resourceRating" action="save" params="[resourceId: resource.id]">
                                <g:if test="${session.user}">
                                    <g:select from="${1..5}" name="newRating" id="newRating"
                                              value="${session.user.getScore(resource.id)}"
                                              resourceId="${resource.id}"/>
                                </g:if>

                            </g:form>
                        </div>

                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        ${resource.description}
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-3">
                        <span class="fa fa-facebook-square"></span>
                        <span class="fa fa-twitter-square"></span>
                        <span class="fa fa-google-plus-square"></span>
                    </div>

                    <div class="col-md-6 col-md-offset-3 ">
                        <g:if test="${session.user}">
                            <ls:canDeleteResource userId="${session.user.id}" resourceId="${resource.id}"/>

                        %{--<a href="#">Edit ||</a>--}%
                            <ls:showResourceEdit id="${resource.id}">
                                <a id="openModal" href="#editModal" data-toggle="modal">Edit</a>
                            </ls:showResourceEdit>
                        </g:if>
                        <ls:showResourceTags id="${resource.id}"/>

                    </div>
                </div>

            </div>
        </div>

    </div>

    <div class="col-md-5">
        <div class="panel panel-primary">
            <div class="panel-heading">
                Trending Topics
            </div>

            <div class="panel-body">
                <g:each in="${trendingTopics}" var="topic">
                    <g:render template="/topic/show" model="[topicObj: topic]"/>
                    <hr/>
                </g:each>
            </div>
        </div>

    </div>
    <g:render template="edit" model="[resourceObj: resource]"/>
</div>
</body>
</html>
