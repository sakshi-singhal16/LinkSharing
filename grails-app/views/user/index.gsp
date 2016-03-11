<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout">
    <title>Link Sharing | ${userObj.getName()}</title>
</head>

<body>
<div class="container">

    <div class="col-md-5">

        <div class="panel-primary">
            <div class="panel-body" style="border: solid 2px">
                <g:render template="show" model="${userObj}"/>
            </div>
        </div>


        <div class="panel-primary" style="margin-top: 20px">
            <div class="panel-heading">
                Subscriptions
            </div>

            <div class="panel-body">
                <g:each in="${subscribedTopics}" var="topic">
                %{--<g:set var="topicObj" value="${topic}" scope="request"/>--}%
                    <g:render template="/topic/show" model="[topicObj: topic]"/>
                    <hr/>
                </g:each>
            </div>
        </div>

        <ls:showTrendingTopics topics="${trendingTopics}"/>

    </div>

    <div class="col-md-7">
        <div class="panel panel-primary">

            <div class="panel-heading">Inbox
            </div>

            <div class="panel-body">
                <g:each in="${readingItems}" var="readingItem">
                    <g:set var="readingItemObj" value="${readingItem}"/>
                    <g:render template="/readingItem/show" model="${readingItemObj}"/>
                    <hr/>
                </g:each>
            </div>
        </div>
    </div>

</div>

</body>
</html>



