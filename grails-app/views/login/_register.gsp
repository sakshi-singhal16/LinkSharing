<div class="panel panel-primary">
    <div class="panel-heading">
        Register
    </div>

    <div class="panel-body">
        <g:form class="form-horizontal" controller="login" action="register">

            <div class="form-group">
                <label class="control-label col-sm-4">First Name</label>

                <div class="col-sm-8">
                    <g:field type="text" class="form-control" name="firstName"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4">Last Name</label>

                <div class="col-sm-8">
                    <g:field type="text" class="form-control" name="lastName"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4">Email</label>

                <div class="col-sm-8">
                    <g:field type="email" class="form-control" name="email"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4">User Name</label>

                <div class="col-sm-8">
                    <g:field type="text" class="form-control" name="userName"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" for="email">Password</label>

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


            <div class="form-group">
                <label class="control-label col-sm-4">Photo</label>

                <div class="col-sm-8">
                    <input type="file" id="photo">
                </div>
            </div>

            <div class="col-md-7"></div>

            <div class="col-md-4">
                <g:submitButton name="register" type="submit" class="btn btn-sm-primary" value="Register"/>
            </div>

        </g:form>
    </div> <!--.panel-body-->

</div>