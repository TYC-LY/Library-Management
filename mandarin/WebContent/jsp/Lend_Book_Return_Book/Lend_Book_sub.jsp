<h1>Lend Book</h1>
	
	<form action="borrow_FindReader" >
		<div class="form-group">
			<label for="readerId">readerId:</label>
			<input class="form-control" name="readerId" type="text" placeholder="" required autofocus="">
			<label for="bookId">bookId:</label>
			<input class="form-control" name="bookId" type="text" placeholder="" required autofocus="">
		</div>
		
		<button class="btn btn-primary" type="submit">Lend Book</button>
	</form>
<br>
<h1 class="text-success"><s:property value="errorMessage"></s:property></h1>
<br>

<div class="card">
  <div class="card-header bg-secondary text-white">
  	Record Detail
  </div>
  <div class="card-body">

		<input name="id" type="hidden" value="<s:property value="tempRecord.id"/>" />
		<input name="readerId" type="hidden" value="<s:property value="tempRecord.readerId"/>" />
		<input name="bookId" type="hidden" value="<s:property value="tempRecord.bookId"/>" />
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
  </div>
  <div class="card-footer">
  </div>
</div>
	