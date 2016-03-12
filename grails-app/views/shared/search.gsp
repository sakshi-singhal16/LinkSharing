<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout">
    <title>Link Sharing | Search results</title>
</head>

<body>
<div class="container">
    <div class="col-md-6">

        <ls:showTrendingTopics topics="${trendingTopics}"/>
        <ls:showTopPosts posts="${topPosts}"/>

    </div>

    <div class="col-md-6">

        <div class="panel panel-info">
            <div class="panel-heading">
                Search results: "${q}"
            </div>

            <div class="panel-body">
                <g:if test="${results}">

                    <g:each in="${results}" var="result">
                        <g:render template="/resource/show" model="[resourceObj: result]"/>
                        <hr/>
                    </g:each>
                </g:if>
                <g:else>
                    <div class="alert-info">No matching results found</div>
                </g:else>

            </div>
        </div>

    </div>
</div>
</body>
</html>
