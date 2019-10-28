<h1>Reader History</h1>
	<p>
		<form action="searchBorrowRecords">
			<div class="input-group mt-3 mb-3">
				<input class="form-control" required autofocus="" name="readerId" type="text"><br />
			</div>
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</p>
	
	<h2><p style="color:#FF0000"><s:property value="errorMessage"/></p></h2>

<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#tobepaid" role="tab" aria-controls="tobepaid" aria-selected="true"><b>Fines to be Paid</b></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#paid" role="tab" aria-controls="paid" aria-selected="false"><b>Other Records</b></a>
  </li>
</ul>

<div id="myTabContent" class="tab-content">
	<div class="tab-pane fade show active" id="tobepaid" role="tabpanel" aria-labelledby="home-tab">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Title</th>
				<th>Amount of Fine</th>
				<th>Borrow Date</th>
				<th>Deadline</th>
				<th>Clear Fine</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="unPayedFine" status="L">
				<tr>
				<form action="clearFine">
				<input type="hidden" name="id" value="<s:property value="id"/>">
				<input type="hidden" name="readerId" value="<s:property value="readerId"/>">
					<td>
						<s:property value="bookId" />
					</td>
					<td>
						<s:property value="bookName" />
					</td>
					<td>
						<s:property value="fineValue" />
					</td>
					<td>
						<s:property value="borrowDate" />
					</td>
					<td>
						<s:property value="deadline" />
					</td>
					<td>
					<button type="submit" class="btn btn-primary" >Clear Fine</button>
					</td>
				</form>	
				</tr>
			</s:iterator>
		</tbody>
	</table>
	</div>
	<div class="tab-pane fade" id="paid" role="tabpanel" aria-labelledby="profile-tab">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Book ID</th>
					<th>Title</th>
					<th>Amount of Fine</th>
					<th>BorrowDate</th>
					<th>Deadline</th>
					<th>ReturnDate</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="payedFine" status="L">
					<tr>
						<td>
							<s:property value="bookId" />
						</td>
						<td>
							<s:property value="bookName" />
						</td>
						<td>
							<s:property value="fineValue" />
						</td>
						<td>
							<s:property value="borrowDate" />
						</td>
						<td>
							<s:property value="deadline" />
						</td>
						<td>
							<s:property value="returnDate" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</div>