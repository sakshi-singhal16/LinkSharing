<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<ls:showUserList/>
%{--<g:if test="${x == 2}">
    "x is 2"
</g:if>
<g:else>
    render "x is not 2"
</g:else>

<g:each var="i" in="${list}">
    i is: ${i} <br/>
</g:each>--}%
%{--
<g:renderErrors bean="${user1}" field="firstName">
    <g:message code="user.not.set.in.register.action"/>
</g:renderErrors>
<g:form>
    <div class="form-group">
        <label for="firstName">Name</label>
        <g:textField name="firstName" value="Enter your name"/>
        <g:fieldError field="firstName" bean="${user1}">

        </g:fieldError>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <g:field type="password" name="password"></g:field>
--}%
%{--</div>--}%

%{--<div class="form-group">
    --}%%{--<label for="cb">Select practice</label>--}%%{--
    <g:checkBox name="cb" value="grails"/><label for="cb">Grails</label><br/>
    <g:checkBox name="cb" value="amc">AMC</g:checkBox><label for="cb">amc</label><br/>
    <g:checkBox name="cb" value="mean">MEAN</g:checkBox><label for="cb">MEAN</label><br/>
</div>
<div class="form-group">
    <label for="age">Age</label>
    <g:select name="age" from="${18..25}" value="" noSelection="['':'Pick your age']"/>
</div>--}%
%{--
    <g:actionSubmit value="Save" action="save"/>

    <g:actionSubmit value="Cancel" action="cancel"/>
    <ls:showAdmin isAdmin="${session.user.isAdmin}">Checked: You are Admin</ls:showAdmin>
    hello<br/>
    hello again
--}%


%{--</g:form>--}%
</body>
</html>