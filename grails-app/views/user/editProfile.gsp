<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="ApplicationLayout"/>
    <title>Link Sharing | Edit profile</title>
</head>

<body>
<div class="col-md-5">
    <div class="panel panel-primary">
        <div class="panel-body">
            <g:render template="show" model="[userObj: user]"/>
        </div>
    </div>

    <div class="panel panel-primary">
        <div class="panel-heading">
            Topics
        </div>

        <div class="panel-body">
            <g:each in="${topicsCreated}" var="topic">
                <g:render template="/topic/show" model="[topicObj: topic]"/>
                <hr/>
            </g:each>
        </div>
    </div>
</div>

<div class="col-md-7">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Profile
        </div>

        <div class="panel-body">
            <g:uploadForm class="form-horizontal"
                          enctype="multipart/form-data">

                <div class="form-group">
                    <label class="control-label col-sm-4">First Name</label>

                    <div class="col-sm-8">
                        <g:field type="text" class="form-control" name="firstName" value="${user?.firstName}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4">Last Name</label>

                    <div class="col-sm-8">
                        <g:field type="text" class="form-control" name="lastName" value="${user?.lastName}"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-4">User Name</label>

                    <div class="col-sm-8">
                        <g:field type="text" class="form-control" name="userName" value="${user?.userName}"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-4">Photo</label>

                    <div class="col-sm-8">
                        <input type="file" name="photo">
                    </div>
                </div>

                <div class="col-md-4 col-md-offset-3">
                    <g:submitButton name="updateProfile" type="submit" class="btn btn-sm-primary" value="Update"/>
                </div>
            </g:uploadForm>

        </div>
    </div>

    <div class="panel panel-primary">
        <div class="panel-heading">
            Change password
        </div>

        <div class="panel-body">
            <g:form>

                <div class="form-group">
                    <label class="control-label col-sm-4">Password</label>

                    <div class="col-sm-8">
                        <g:field type="password" class="form-control" name="password"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4">Confirm password</label>

                    <div class="col-sm-8">
                        <g:field type="password" class="form-control" name="confirmPassword"/>
                    </div>
                </div>

                <div class="col-md-4 col-md-offset-3">
                    <g:submitButton name="changePassword" type="submit" class="btn btn-sm-primary" value="Update"/>
                </div>
            </g:form>
        </div>

    </div>
</div>

</body>
</html>