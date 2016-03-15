<div class="panel panel-primary">
    <div class="panel-heading">
        Login
    </div>

    <div class="panel-body">
        <g:form class="form-horizontal" controller="login" action="login">
            <div class="form-group">
                <label class="control-label col-sm-4" for="userName">Username</label>

                <div class="col-sm-8">
                    <g:textField class="form-control" name="userName" value="Username.."/>
                    %{--<g:fieldError field="userName" bean="${user}" message="${message}"/>--}%
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" for="password">Password</label>

                <div class="col-sm-8">
                    <g:field type="password" class="form-control" name="password"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2 col-md-offset-3">
                    <g:actionSubmit class="btn btn-sm-primary" name="login" type="submit" value="Login" action="login"/>
                </div>

                <div class="col-md-4">
                    <a id="openModal" href="#forgotPasswordModal" data-toggle="modal">
                        Forgot Password
                    </a>

                </div>
            </div>
        </g:form>
    </div>
</div>
<g:render template="/user/forgotPassword"/>