<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Link Sharing | Search results</title>
</head>

<body>
<div class="container">
    <div class="col-md-6">

        <ls:showTrendingTopics posts="${trendingTopics}"/>
        <ls:showTopPosts posts="${topPosts}"/>

    </div>

    <div class="col-md-6">
        <g:if test="${results}">

            <g:each in="${results}" var="result">
                ${result}
                <hr/>
            </g:each>

        </g:if>
        <g:else>
            no results
        </g:else>
    </div>
</div>
</body>
</html>
