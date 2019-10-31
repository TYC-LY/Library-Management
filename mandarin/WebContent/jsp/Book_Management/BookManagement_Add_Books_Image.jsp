<h1>Result:</h1>

<h2 class="text-success"><s:property value="errorMessage"/></h2>

<h1>Add more Books:</h1>

<form action="BookManagement_Add_Books_Copy">
	<label for="book_copy_number">The number of the book that you want to add:</label>
	<input name="book_copy_number" />
	<button class="btn btn-primary" name="submit" type="submit">Add Copy</button>
</form>

<table class="table table-hover">
		<thead>
			<tr>
				<th>id</th>
				<th>BarCode</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="idList" >
				<tr>
						<td>
							<s:property value="idCopy"/>
						</td>
						<td>
							<img src="D:/barcode/<s:property value="idCopy"/>.jpg" width="300" height="50">
						</td>
						<td>
							 <img src="D:/booklocation/<s:property value="idCopy"/>.png" width="300" height="50">
						</td>
				</tr>
			</s:iterator>
		</tbody>
</table>
