<!-- col-sm-8 Books Delete -->
<h1>Books Delete</h1>
     						
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Book ID</th>
				<th>ISBN</th>
				<th>Librarian ID</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="records" >
				<tr>		
						<td>
							<s:property value="bookId"/>
						</td>
						<td>
							 <s:property value="ISBN"/>
						</td>
						<td>
							 <s:property value="librarianId"/>
						</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>