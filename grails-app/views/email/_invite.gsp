<%@ page contentType="text/html" %>
<div>
    <h4>
        Hey!<br/>
        I would like to invite you to the follow this topic I found interesting on <b>Link sharing</b>

    </h4>

    <a href="http://localhost:8080/topic/join/${topicId}">
        http://localhost:8080/topic/join/${topicId}
    </a>

    --${session.user.getName()}
</div>
