<!-- col-sm-8 Delete Announcement -->
<h1>Delete Announcement</h1>
	<form action="viewAnnouncements_Delete">
		<button type="submit" class="btn btn-primary" >Refresh</button>
	</form>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>author</th>
				<th>title</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="announcements" status="">
				<tr>		
					<form action="deleteAnnouncement">
							<input type="hidden" name="id" readonly="readonly" value="<s:property value="id"/>"/>
						<td>
							<s:property value="author"/>
						</td>
						<td>
							<s:property value="title"/>
						</td>
						<td>
							<button type="submit" class="btn btn-danger" >Delete</button>
						</td>
					</form>				
					<br>
				</tr>
			</s:iterator>
		</tbody>
	</table>