<div id="editdModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">

                <h4 class="modal-title">Edit Resource</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="resource" action="updateDescription">

                    <div class="form-group">
                        <label class="control-label col-sm-4">Description:</label>

                        <div class="col-sm-8">
                            <g:textArea name="newDescription" cols="40" rows="4" value="${resourceObj.description}"/>
                            <g:hiddenField name="resourceId" value="${resourceObj.id}"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4 col-md-offset-2">

                            <g:submitButton type="submit" name="sendPasswordLink" value="Save description"
                                            class="btn btn-block btn-primary"/>
                        </div>

                        <div class="col-md-3">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>
