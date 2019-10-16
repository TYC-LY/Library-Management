<!-- col-sm-8 Edit Books -->
<h1>Edit Books</h1>
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
				<input  name="pageState" type="hidden" value="edit"><br />
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
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="books" status="L">
				<tr>
					<form action="BookManagement_Edit_Books">
						<input type="hidden" name="id" value="<s:property value="id"/>">
						<input type="hidden" name="borrowState" value="<s:property value="borrowState"/>">
						<input type="hidden" name="reservationState" value="<s:property value="reservationState"/>">
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
							<s:property value=" reservationState" />
						</td>
						<td>
							<button type="button" class="btn btn-primary btn-block" data-toggle="modal"
								data-target="#ddd<s:property value="#L.index+1"></s:property>">Edit</button>
						</td>
						<div class="modal fade" id="ddd<s:property value="#L.index+1"></s:property>">
							<div class="modal-dialog">
								<div class="modal-content">
						
									<!-- 模态框头部 -->
									<div class="modal-header">
										<h4 class="modal-title"><strong>Edit Book</strong></h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
						
									<!-- 模态框主体 -->
									<div class="modal-body">
											<label for="ISBN">ISBN:</label>
											<input class="form-control" name="ISBN" type="text" required autofocus="" placeholder="ISBN" value="<s:property value="ISBN"/>" >
											<label for="title">title:</label>
											<input class="form-control" name="title" type="text" required autofocus="" placeholder="title"  value="<s:property value="title"/>" >
											<label for="author">author:</label>
											<input class="form-control" name="author" type="text" required autofocus="" placeholder="author"  value="<s:property value="author"/>" >
											<label for="publisher">publisher:</label>
											<input class="form-control" name="publisher" type="text" required autofocus="" placeholder="publisher"  value="<s:property value="publisher"/>" >
											<label for="description">description:</label>
											<input class="form-control" name="description" type="text" required autofocus="" placeholder="description"  value="<s:property value="description"/>" >
											<label for="location">location:</label>
											<p>
												floor <s:property value="location_floor"/> stack <s:property value="location_stack"/> area <s:property value="location_area"/>
											</p>
											<label for="location_floor">location floor:</label>
											<div class="input-group-prepend">
												<select name="location_floor">
													<div class="dropdown-menu">
												  	<option value ="1">1</option>
												  	<option value ="2">2</option>
												  	<option value="3">3</option>
												  	<option value="4">4</option>
												  	</div>
												</select>
											</div>
											<label for="location_stack">location stack:</label>
											<div class="input-group-prepend">
												<select name="location_stack">
													<div class="dropdown-menu">
												  	<option value ="1">1</option>
												  	<option value ="2">2</option>
												  	<option value="3">3</option>
												  	<option value="4">4</option>
												  	</div>
												</select>
											</div>
											<label for="location_area">location area:</label>
											<div class="input-group-prepend">
												<select name="location_area">
													<div class="dropdown-menu">
												  	<option value ="1">1</option>
												  	<option value ="2">2</option>
												  	<option value="3">3</option>
												  	<option value="4">4</option>
												  	</div>
												</select>
											</div>
											<label for="price">price:</label>
											<input class="form-control" name="price" type="text" required autofocus="" placeholder="price"  value="<s:property value="price"/>" >
											<label for="categoryNo">categoryNo:</label>
											<input class="form-control" name="categoryNo" type="text" required autofocus="" placeholder="categoryNo" value="<s:property value="categoryNo"/>">
											<input  name="imagePath" type="hidden" value="<s:property value="imagePath"/>"><br />
											<button type="submit" class="btn btn-primary" >Complete</button>
											<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
									</div>
						
								</div>
							</div>
						</div>
					</form>
				</tr>
			</s:iterator>
		</tbody>
	</table>