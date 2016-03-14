<%@ page import="com.tothenew.linksharing.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout"/>
    <title>Link Sharing | Users</title>
</head>

<body>
<div>
    <div>
        <div class="h3">
            Link Sharing users::
        </div>
        <br/>
        <br/>

        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        Users
                    </div>

                    <div class="col-xs-offset-2 col-xs-7">
                        <g:form name="adminUsersSearchForm" class="form-inline" controller="user" action="showUsers">
                            <div class="form-group">
                                <div class="input-group">
                                    <select name="isActive" id="isActive" class="btn btn-default">
                                        <option value="${null}">All users</option>
                                        <option value="${true}">Active users</option>
                                        <option value="${false}">Inactive users</option>
                                    </select>

                                    &nbsp;&nbsp;&nbsp;



                                    <span class="input-group-btn">
                                        <input type="text" id="q" name="q" class="form-control input-group"
                                               placeholder="Search users.. ">
                                    </span>

                                    <span class="input-group-btn">
                                        <g:submitButton name="serach" class="btn btn-primary" value="Search"/>
                                    </span>

                                </div>
                            </div>
                        </g:form>
                    </div>
                </div>

            </div>

            <div class="panel-body">
                <table class="table table-striped table-bordered">

                    <thead>
                    <tr>
                        <g:sortableColumn property="id" title="Id"/>
                        <g:sortableColumn property="userName" title="Username"/>
                        <g:sortableColumn property="email" title="Email"/>
                        <g:sortableColumn property="firstName" title="First name"/>
                        <g:sortableColumn property="lastName" title="Last name"/>
                        <g:sortableColumn property="isActive" title="Active"/>
                        <th>Manage</th>
                    </tr>
                    </thead>
                    <g:each in="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.userName}</td>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td><ls:showActiveStatus userId="${user.id}"/></td>
                            <td><ls:showActivateLink userId="${user.id}"/></td>
                        </tr>
                    </g:each>
                </table>
            </div>
        </div>

    </div>
</div>
</body>
</html>