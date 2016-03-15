<div class="panel panel-primary">
    <div class="panel-heading">
        Register
    </div>

    <div class="panel-body">
        <g:uploadForm id="registrationForm" class="form-horizontal" controller="user" action="register"
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
                <label class="control-label col-sm-4">Email</label>

                <div class="col-sm-8">
                    <g:field type="email" class="form-control" name="email" value="${user?.email}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4">User Name</label>

                <div class="col-sm-8">
                    <g:field type="text" class="form-control" name="userName" value="${user?.email}"/>
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
                    <input type="file" name="photo">
                </div>
            </div>


            <div class="col-md-4 col-md-offset-3">
                <g:submitButton name="register" type="submit" class="btn btn-sm-primary" value="Register"/>
            </div>

        </g:uploadForm>
    </div> <!--.panel-body-->

    <script>
        $(document).ready(function () {
            $(function () {
                $('#registrationForm').validate({
                    rules: {
                        firstName: {
                            required: true
                        },
                        lastName: {
                            required: true
                        },
                        email: {
                            required: true,
                            remote: "/user/validateEmail"
                        },
                        userName: {
                            required: true,
                            remote: {
                                url: "/user/validateUserName",
                                type: "post"

                            }
                        },
                        password: {
                            required: true,
                            minlength: 5
                        },
                        confirmPassword: {
                            required: true
//                    matchesPassword: true
                        }
                    },
                    messages: {
                        firstName: {
                            required: "First Name is required"
                        },
                        email: {
                            remote: "Email already exists"
                        },
                        userName: {
                            remote: "Username already exists"
                        }
                    }
                });
            });


        });
    </script>
</div>