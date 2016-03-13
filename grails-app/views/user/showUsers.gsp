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
        <table class="table table-striped table-bordered">

            %{--
                        <div class="col-md-3">
                            Users
                        </div>

                        <div class="col-md-5">
                            <g:form role="search">
                                <div class="form-group">
                                    <span>
                                        <g:field type="text" class="form-control" placeholder="Search" name="q"/>
                                    </span>
                                    <span>
                                        <g:submitButton name="search" type="submit" class="btn btn-default" value="Search"/>

                                    </span>
                                </div>
                            </g:form>
                        </div>
            --}%

            <tr class="text text-center">
                <b>
                    <td>Id</td>
                    <td>Username</td>
                    <td>Email</td>
                    <td>FirstName</td>
                    <td>Last Name</td>
                    <td>Active</td>
                    <td>Manage</td>
                </b>

            </tr>
            <g:each in="${com.tothenew.linksharing.User.list()}" var="user">
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
</body>
</html>