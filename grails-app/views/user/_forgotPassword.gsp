<div id="forgotPasswordModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">

                <h4 class="modal-title">Forgot Password</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" action="save" controller="topic">

                    <div class="form-group">
                        <label class="control-label col-sm-4">Email:</label>

                        <div class="col-sm-8">
                            <g:field type="email" class="form-control" name="email"
                                     placeholder="Your registered email id here..."/>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <g:submitButton type="submit" name="sendPasswordLink" value="E-mail me the password link"
                                        class="btn btn-block btn-primary"/>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>
