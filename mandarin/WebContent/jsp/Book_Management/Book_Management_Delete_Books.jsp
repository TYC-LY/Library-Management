<h1>Delete Books</h1>
	<p>
		<form action="BookManagement_Search_Books">
			<div class="input-group mt-3 mb-3">
				<div class="input-group-prepend">
					<select name="condition">
						<div class="dropdown-menu">
							<option value="ISBN">ISBN</option>
							<option value="title">Title</option>
							<option value="author">Author</option>
						</div>
					</select>
				</div>
				<input class="form-control" name="content" type="text"><br />
				<input  name="pageState" type="hidden" value="delete"><br />
			</div>
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</p>
	
	<h1><p class="text-success"><s:property value="errorMessage"/></p></h1>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Author</th>
				<th>BorrowState</th>
				<th>ReservationState</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="books" status="L">
				<tr>
					<form action="BookManagement_Delete_Books">
						<input type="hidden" name="tempBookId" value="<s:property value="id"/>">
						<input type="hidden" name="bookId" value="<s:property value="id"/>">
						<input type="hidden" name="ISBN" value="<s:property value="ISBN"/>">
						<input type="hidden" name="borrowState" value="<s:property value="borrowState"/>">
						<input type="hidden" name="reservationState" value="<s:property value="reservationState"/>">
						<input type="hidden" name="title" value="<s:property value="title"/>">
						<td>
							<s:property value="ISBN" />
						</td>
						<td>
							<s:property value="title" />
						</td>
						<td>
							<s:property value="author" />
						</td>
						<td>
							<s:if test="%{borrowState==false}">
								<p class="text-secondary"><s:property value="borrowState" /></p>
							</s:if>
							<s:else>
								<p class="text-success font-weight-bold"><s:property value="borrowState"/></p>
							</s:else>
						</td>
						<td>
							<s:if test="%{reservationState==false}">
								<p class="text-secondary"><s:property value=" reservationState" /></p>
							</s:if>
							<s:else>
								<p class="text-success font-weight-bold"><s:property value=" reservationState" /></p>
							</s:else>
						</td>
						<td>
							<button type="button" class="btn btn-danger btn-block" data-toggle="modal"
								data-target="#ddd<s:property value="#L.index+1"></s:property>">Delete</button>
						</td>
						<div class="modal fade" id="ddd<s:property value="#L.index+1"></s:property>">
							<div class="modal-dialog">
								<div class="modal-content">

									<!-- 模态框头部 -->
									<div class="modal-header">
										<h4 class="modal-title">Really Delete <i><s:property value="title" /></i> ?</h4>
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
				</tr>
			</s:iterator>
		</tbody>
	</table>