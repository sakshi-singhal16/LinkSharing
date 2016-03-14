<div id="shareLinkModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Create Link Resource</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="linkResource" action="save">

                    <div class="form-group">
                        <label class="control-label col-sm-4">Link URL</label>

                        <div class="col-sm-8">
                            <g:field type="text" class="form-control" name="url"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Description</label>

                        <div class="col-sm-8">
                            <g:textArea class="form-control" name="description" rows="3" cols="10"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Topic</label>

                        <div class="col-sm-8">
                            <div class="dropdown">
                                <g:select name="topicId" from="${subscribedTopics}" optionKey="id"
                                          optionValue="${{ it }}" noSelection="['': '--Select a topic--']"/>
                            </div>
                        </div>
                    </div>

                    <span>
                        <span><g:actionSubmit action="save" type="submit" name="createLink" value="Create"
                                              class="btn btn-block btn-primary"/></span>
                        <span><button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </span>

                    </span>
                </g:form>
            </div><!--.modal-body-->

        </div>
    </div>
</div>