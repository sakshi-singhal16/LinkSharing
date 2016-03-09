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
            <hr/>
        </g:each>
    </div>
</div>