<!-- 模态框 Announcement Management_Add Announcement -->
<div class="modal fade" id="AddAnnouncement">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- 模态框头部 -->
			<div class="modal-header">
				<h4 class="modal-title">Add Announcement</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- 模态框主体 -->
			<div class="modal-body">
				<form action="createAnnouncement">
					<input name="state" type="hidden" value="Add" /> 
					<label for="title">Title:</label>
					<input class="form-control" name="title" type="text"> 
					<label for="Content">Content:</label> 
					<input class="form-control" name="content" type="text"><br />
					<button type="submit" class="btn btn-primary">Create</button>
				</form>
			</div>

			<!-- 模态框底部 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>