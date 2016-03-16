<div id="shareLinkModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Create Link Resource</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" name="createLinkResourceForm" controller="linkResource" action="save">

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

                    <div class="row">
                        <div class="col-md-5 col-md-offset-2">
                            <g:actionSubmit action="save" type="submit" name="createLink" value="Create" class="btn btn-block btn-primary"/>
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
<g:javascript src="jquery.validate.min.js">
</g:javascript>
<script>
    $(document).ready(function () {
        $('#createLinkResourceForm').validate({
            rules: {
                url: {
                    required: true,
                    url: true
                },
                description: {
                    required: true
                },
                topicId: {
                    required: true
                }
            },
            messages: {
                url: {
                    required: "This field is required",
                    url: "Please enter a valid URL"
                },
                description: {
                    required: "This field is required"
                },
                topicId: {
                    required: "This field is required"
                }
            }
        });
    });

</script>
