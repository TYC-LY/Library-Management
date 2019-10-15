<h1>Search Books</h1>
	<p>
		<form action="BookManagement_Search_Books">
			<div class="input-group mt-3 mb-3">
				<div class="input-group-prepend">
					<select name="condition">
						搜索条件
						<div class="dropdown-menu">
							<option value="ISBN">ISBN</option>
							<option value="title">Title</option>
							<option value="author">Author</option>
						</div>
					</select>
				</div>
				<input class="form-control" name="content" type="text"><br />
			</div>
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</p>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Author</th>
				<th>BorrowState</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="books">
				<tr>
					<form action="BookManagement_Delete_Books">
						<input type="hidden" name="id" value="<s:property value="id"/>">
						<td>
							<s:property value=" ISBN" />
						</td>
						<td>
							<s:property value="title" />
						</td>
						<td>
							<s:property value="author" />
						</td>
						<td>
							<s:property value=" borrowState" />
						</td>
						<td>
							<button type="button" class="btn btn-danger btn-block" data-toggle="modal"
								data-target="#Delete">Delete</button>
						</td>
						<div class="modal fade" id="Delete">
							<div class="modal-dialog">
								<div class="modal-content">

									<!-- 模态框头部 -->
									<div class="modal-header">
										<h4 class="modal-title">Really Delete?</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<!-- 模态框主体 -->
									<div class="modal-body">
										<button type="submit" class="btn btn-primary">Yes</button>
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Cancel</button>
									</div>

								</div>
							</div>
						</div>
					</form>
					<br>
				</tr>
			</s:iterator>
		</tbody>
	</table>