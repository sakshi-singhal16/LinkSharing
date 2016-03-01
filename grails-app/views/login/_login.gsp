<div class="panel panel-default">
    <div class="panel-heading">
        Login
    </div>

    <div class="panel-body">
        <g:form class="form-horizontal" controller="login" action="login">
            <div class="form-group">
                <label class="control-label col-sm-4" for="userName">Username*</label>

                <div class="col-sm-8">
                    <g:textField class="form-control" name="userName" placeholder="Name.."/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" for="password">Password*</label>

                <div class="col-sm-8">
                    <g:field type="password" class="form-control" name="password"/>
                </div>
            </div>

            <div>
                <div class="col-md-7">
                    <g:link href="#">Forgot Password</g:link>
                </div>

                <div class="col-md-4">
                    <g:actionSubmit name="login" type="submit" value="Login" action="login"/>
                </div>
            </div>
        </g:form>
    </div>
</div>
