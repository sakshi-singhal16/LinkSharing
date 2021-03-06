<div id="inviteModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="topic" action="invite">

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
                                <g:select name="topicId" from="${session.user.subscribedTopics}" optionKey="id"
                                          optionValue="${{ it }}" noSelection="['': '--Select a topic--']"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-2 col-md-offset-2">
                            <g:submitButton name="invite" class="btn btn-primary" value="Invite"/>
                        </div>

                        <div class="col-md-3">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </g:form>

            </div><!--.modal-body-->

        </div>
    </div>
</div>