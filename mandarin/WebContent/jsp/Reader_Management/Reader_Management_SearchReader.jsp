
<h1>Manage Reader</h1>
<p>
<form action="readerManagement_Search">
	<div class="input-group mt-3 mb-3">
		<div class="input-group-prepend">
			<select name="condition">
				<div class="dropdown-menu">
					<option value="id">ReaderId</option>
					<option value="phoneNumber">PhoneNumber</option>
					<option value="email">Email</option>
				</div>
			</select>
		</div>
		<input class="form-control" name="content" type="text">
	</div>
	<button type="submit" class="btn btn-primary">Search</button>
</form>
</p>

<h1>
	<p class="text-success">
		<s:property value="errorMessage" />
	</p>
</h1>

<div class="card">
	<div class="card-header bg-secondary text-white">Reader
		Information</div>
	<div class="card-body">
		<form action="readerManagement_Delete">
			<label for="ReaderId">ReaderId:</label> <input type="hidden"
				id="value" class="form-control" name="id"
				value="<s:property value="tempReader.id"/>" />
			<s:property value="tempReader.id" />
			<br> <label for="Username">Username:</label> <input
				type="hidden" class="form-control"
				value="<s:property value="tempReader.username"/>" />
			<s:property value="tempReader.username" />
			<br> <label for="PhoneNumber">PhoneNumber:</label> <input
				type="hidden" class="form-control"
				value="<s:property value="tempReader.phoneNumber"/>" />
			<s:property value="tempReader.phoneNumber" />
			<br> <label for="Email">Email:</label> <input type="hidden"
				class="form-control" value="<s:property value="tempReader.email"/>" />
			<s:property value="tempReader.email" />
			<br> <label for="FineState">FineState:</label> <input
				type="hidden" class="form-control" name="fineState"
				value="<s:property value="tempReader.fineState"/>" />
			<s:property value="tempReader.fineState" />
			<br> <label for="BorrowBookNumber">BorrowBookNumber:</label> <input
				type="hidden" class="form-control" name="borrowBookNumber"
				value="<s:property value="tempReader.borrowBookNumber"/>" />
			<s:property value="tempReader.borrowBookNumber" />
			<br>
	</div>

	<div class="card-footer">
		<button type="button" id="Del" class="btn btn-danger"
			data-toggle="modal" data-target="#deleteReader">Delete</button>

		<button type="button" id="Edit" class="btn btn-primary"
			data-toggle="modal" data-target="#editReader">Edit</button>
	</div>

	<div class="modal fade" id="deleteReader">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- 模态框头部 -->
				<div class="modal-header">
					<h4 class="modal-title">
						Really Delete the reader
						<s:property value="tempReader.username" />
						?
					</h4>
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
</div>

<script>
			$(document).ready(function() {
				$("#Del").click(function() {
					var text = $("#value").val();
					if (text == "") {
						$(this).attr("disabled", true);
					}
				})
			});
		</script>
</form>


<div class="modal fade" id="editReader">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- 模态框头部 -->
			<div class="modal-header">
				<h4 class="modal-title">Edit Reader</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form action="readerManagement_Edit">
				<div class="modal-body">
					<label for="readerId">ReaderId:</label> <input type="hidden"
						class="form-control" name="id"
						value="<s:property value="tempReader.id"/>" />
					<s:property value="tempReader.id" />
					<br> <label for="newUsername">Username:</label> <input
						class="form-control" name="username" type="text"
						placeholder="newUsername" required autofocus=""
						value="<s:property value="tempReader.username" />"> <label
						for="newPhone">PhoneNumber:</label> <input class="form-control"
						name="phoneNumber" type="text" placeholder="newPhoneNumber"
						required autofocus=""
						value="<s:property value="tempReader.phoneNumber"/>"> <label
						for="newEmail">Email:</label> <input class="form-control"
						name="email" type="text" placeholder="email" required autofocus=""
						value="<s:property value="tempReader.email"/>"> <label
						for="newBorrowBookNumber">BorrowBookNumber:</label> <input
						class="form-control" name="borrowBookNumber" type="text"
						placeholder="newBorrowBookNumber" required autofocus=""
						value="<s:property value="tempReader.borrowBookNumber"/>">
					<label for="newPassword">Password:</label> <input
						class="form-control" name="password" type="text"
						placeholder="password" required autofocus=""
						value="<s:property value="tempReader.password"/>"> <br>
					<input type="hidden" class="form-control" name="createDate"
						value="<s:property value="tempReader.createDate"/>" /> <input
						type="hidden" class="form-control" name="fineState"
						value="<s:property value="tempReader.fineState"/>" /> <input
						type="hidden" class="form-control" name="checkState"
						value="<s:property value="tempReader.checkState"/>" />


					<button type="submit" class="btn btn-primary">Yes</button>

					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
		$(document).ready(function() {
			$("#Edit").click(function() {
				var text = $("#value").val();
				if (text == "") {
					$(this).attr("disabled", true);
				}
			})
		});
	</script>
</div>
