<!-- col-sm-8 Books Delete -->
<h1>Books Delete</h1>
     						
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Book ID</th><br/>
				<th>ISBN</th><br/>
				<th>Librarian ID</th><br/>
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
					<br>
				</tr>
			</s:iterator>
		</tbody>
	</table>