<!-- col-sm-8 View Library Income History -->
<h1>Select the duration</h1>
		<form action="viewDeposit">
			<label id="startDate">startDate</label>
			<input type='text' class="form-control" id="startdatetime" name="startDate"/>
			<label id="endDate">endDate</label>
			<input type='text' class="form-control" id="enddatetime" name="endDate"/>
			<br>
			<button class="btn btn-primary" type="submit">View</button>
		</form>
 		<script type="text/javascript">
	 		$(function() {
				$("#startdatetime").datetimepicker({
					format: 'YYYY-MM-DD',
					locale: moment.locale('zh-cn')
				});
				$("#enddatetime").datetimepicker({
					format: 'YYYY-MM-DD',
					locale: moment.locale('zh-cn')
				});
			});
	 	</script>
	 	
	 	<br>
	 	
	 	<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item">
				<a class="nav-link active" id="home-tab" data-toggle="tab" href="#depositHistory" role="tab" aria-controls="depositHistory" aria-selected="true">Deposit History</a>
			</li>
	  		<li class="nav-item">
	    		<a class="nav-link" id="profile-tab" data-toggle="tab" href="#fineHistory" role="tab" aria-controls="fineHistory" aria-selected="false">Fine History</a>
	  		</li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="depositHistory" role="tabpanel" aria-labelledby="home-tab">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Deposit</th>
							<th>ReaderId</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="Readers" >
							<tr>		
									<td>
										300RMB
									</td>
									<td>
										 <s:property value="id"/>
									</td>
									<td>
										 <s:property value="createDate"/>
									</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
							
			</div>
			<div class="tab-pane fade" id="fineHistory" role="tabpanel" aria-labelledby="profile-tab">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Fine</th>
								<th>readerId</th>
								<th>bookId</th>
								<th>Date</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="fineList" >
								<tr>		
										<td>
											 <s:property value="fineValue"/>RMB
										</td>
										<td>
											<s:property value="readerId"/>
										</td>
										<td>
											 <s:property value="bookId"/>
										</td>
										<td>
											 <s:property value="returnDate"/>
										</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
			</div>
		</div>