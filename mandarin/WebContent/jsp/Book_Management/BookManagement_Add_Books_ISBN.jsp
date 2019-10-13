<!-- 模态框 AddBook -->
			<div class="modal fade" id="AddBook">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- 模态框头部 -->
						<div class="modal-header">
							<h4 class="modal-title">Add Book</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- 模态框主体 -->
						<div class="modal-body">
							<h2>Please Enter the ISBN of the Book!</h2>
							<form action="bookManagement_Find_Book_Detail">
								<div class="form-group">
									<label for="ISBN">ISBN:</label> <input class="form-control"
										name="ISBN" type="text" placeholder="ISBN" required
										autofocus="">
								</div>

								<button class="btn btn-primary" type="submit">Find the
									detail of book</button>
							</form>
						</div>

						<!-- 模态框底部 -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>
