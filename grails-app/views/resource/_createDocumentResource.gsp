<div id="shareDocumentModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Create Document Resource</h4>
            </div>

            <div class="modal-body">
                <form class="form-horizontal">

                    <div class="form-group">
                        <label class="control-label col-sm-4">Document</label>

                        <div class="col-sm-8">
                            <input type="file" id="document">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4">Description</label>

                        <div class="col-sm-8">
                            <textarea class="form-control" id="linkDesc" rows="3" cols="10"></textarea>
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


                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Share</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>

                </form>
            </div><!--.modal-body-->
        </div>
    </div>
</div>