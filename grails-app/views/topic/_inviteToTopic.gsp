<div id="inviteModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal">

                    <div class="form-group">
                        <label class="control-label col-sm-4">Email</label>

                        <div class="col-sm-8">
                            <g:field type="text" class="form-control" name="email"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Topic</label>

                        <div class="col-sm-8">
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    Topic
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="#">Grails</a></li>
                                    <li><a href="#">MEAN</a></li>
                                    <li><a href="#">AMC</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </g:form>
            </div><!--.modal-body-->

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Invite</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>

        </div>
    </div>
</div>