<!-- col-sm-8 Edit Announcement -->
	<h1>Edit Announcement</h1>
	
	<form action="viewAnnouncements_Edit">
		<button type="submit" class="btn btn-primary">refresh</button>
	</form>
	
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>author</th>
				<th>title</th>
				<th>View</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="announcements" status="">
				<tr>
					<form action="viewAnnouncement">
								<input type="hidden" name="announcementId" readonly="readonly" value="<s:property value="id"/>"/>
							<td>
								<s:property value="author"/>
							</td>
							<td>
								<s:property value="title"/>
							</td>
							<td>
								<button type="submit" class="btn btn-primary">View</button>
							</td>
					</form>
					<br>
				</tr>
			</s:iterator>
		</tbody>
	</table>