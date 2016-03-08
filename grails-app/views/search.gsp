%{--
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Link Sharing | Search results</title>
</head>

<body>
<div class="container">
    <div class="col-md-6">

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
        SEARCH RESULTS
    </div>
</div>
</body>
</html>--}%
