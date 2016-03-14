<div id="editdModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">

                <h4 class="modal-title">Edit Resource</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="user" action="forgot">

                    <div class="form-group">
                        <label class="control-label col-sm-4">Description:</label>

                        <div class="col-sm-8">
                            <g:textArea name="description" cols="15" rows="4" value="${resourceObj.description}"/>
                        </div>
                    </div>


                    <div>
                        <g:submitButton type="submit" name="sendPasswordLink" value="Get new password"
                                        class="btn btn-block btn-primary"/>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>
