<%@ page import="com.tothenew.linksharing.Enums.Visibility" %>
<div id="createTopicModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">

                <h4 class="modal-title">Create Topic</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" action="save" controller="topic">

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
                                <g:select name="visibility"
                                          from="${com.tothenew.linksharing.Enums.Visibility.values()}"/>

                            </div>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <g:submitButton type="submit" name="createTopic" value="Create"
                                        class="btn btn-block btn-primary"/>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>
                </g:form>
            </div>

        </div>
    </div>
</div>
