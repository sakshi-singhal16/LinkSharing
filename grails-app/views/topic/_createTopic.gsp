<%@ page import="com.tothenew.linksharing.Enums.Visibility" %>
<div id="createTopicModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">

                <h4 class="modal-title">Create Topic</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="topic" action="save">

                    <div class="form-group">
                        <label class="control-label col-sm-4" for="topicName">Name</label>

                        <div class="col-sm-8">
                            <g:field type="text" class="form-control" name="topicName"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4" for="visibility">Visibility</label>

                        <div class="col-sm-8">
                            <div class="dropdown">
                                <g:select name="visibility" from="${Visibility.values()}"
                                          noSelection="['': '-Select visibility-']"/>
                            </div>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <div class="row">
                            <div class="col-md-4 col-md-offset-2">
                                <g:submitButton type="submit" name="createTopic" value="Create Topic"
                                                class="btn btn-block btn-primary"/>
                            </div>

                            <div class="col-md-4">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>