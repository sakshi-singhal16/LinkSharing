<div class="panel-primary" style="margin-top: 20px">
    <div class="panel-heading">
        Trending Topics
    </div>

    <div class="panel-body">
        <g:each in="${trendingTopics}" var="topic">
            <g:set var="topicObj" value="${topic}"/>
            <g:render template="/topic/show" model="${topicObj}"/>
            <hr/>
        </g:each>
    </div>
</div>