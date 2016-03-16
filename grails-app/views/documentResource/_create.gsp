<%@ page contentType="text/html;charset=UTF-8" %>
<div id="shareDocumentModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Create Document Resource</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="documentResource" action="save"
                        enctype="multipart/form-data">

                    <div class="form-group">
                        <label class="control-label col-sm-4">File Path</label>

                        <div class="col-sm-8">
                            <input type="file" name="docResource" accept="application/pdf"/>
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
                                <g:select name="topic" from="${subscribedTopics}" optionKey="id"
                                          optionValue="${{ it }}" noSelection="['': '--Select a topic--']"/>

                            </div>
                        </div>
                    </div>




                    <div class="row">
                        <div class="col-md-5 col-md-offset-2">
                            <g:submitButton type="submit" name="createDoc" value="Create" class="btn btn-block btn-primary"/>
                        </div>

                        <div class="col-md-3">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>

                </g:form>
            </div><!--.modal-body-->
        </div>
    </div>
</div>