<h1>Return Book</h1>

<form action="searchBorrowRecord" >
		<div class="form-group">
			<label for="bookId">bookId:</label>
			
			<input class="form-control" name="bookId" type="text" required autofocus="">
		</div>
		<button class="btn btn-primary" type="submit">Return</button>
</form>

<br>
<h1 class="text-success"><s:property value="errorMessage"></s:property></h1>
<br>


<div class="card">
  <div class="card-header bg-secondary text-white">
  	Record Detail
  </div>
  <div class="card-body">
  	<form action="return_RecordUpdate" >
		<label for="RecordId">RecordId:</label> 
		<input class="form-control" value="<s:property value="tempRecord.id"/>" />
		<br>
		<label for="ReaderId">ReaderId:</label>
		<input class="form-control" value="<s:property value="tempRecord.readerId"/>" />
		<br>
		<label for="BookId">BookId:</label>
		<input class="form-control" value="<s:property value="tempRecord.bookId"/>" />
		<br>
		<label for="BorrowDate">BorrowDate:</label>
		<input class="form-control" value="<s:property value="tempRecord.borrowDate"/>" />
		<br>
		<label for="Deadline">Deadline:</label>
		<input class="form-control" value="<s:property value="tempRecord.deadline"/>" />
		<br>
		<label for="ReturnDate">ReturnDate:</label>
		<input class="form-control" value="<s:property value="tempRecord.returnDate"/>" />
		<br>
		<label for="fineValue">FineValue:</label>
		<input class="form-control" value="<s:property value="tempRecord.fineValue"/>" />
		<br>
		<button class="btn btn-primary" type="submit">Yes</button>
	</form>
  </div> 
  <div class="card-footer">
  </div>
</div>
