<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout">
    <title></title>
</head>

<body>
<div class="container">
    <div class="col-md-6">
        <g:render template="/resource/show"/>
        <g:render template="/topic/show"/>
    </div>

    <div class="col-md-6">
        <g:render template="/login/login"/>
        <g:render template="register"/>
    </div>
</div>
</body>
</html>