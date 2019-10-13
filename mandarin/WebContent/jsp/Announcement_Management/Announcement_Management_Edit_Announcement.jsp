<!-- col-sm-8 Edit Announcement -->
	<h1>Edit Announcement</h1>
	
	<form action="viewAnnouncements_Edit">
		<button type="submit" class="btn btn-primary">refresh</button>
	</form>		
	
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>author</th>
				<th>title</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="announcements" status="">
				<tr>
					<form action="viewAnnouncement">
							<td>
								<input name="announcementId" readonly="readonly" value="<s:property value="id"/>"/>
							</td>
							<td>
								<input name="author" readonly="readonly" value="<s:property value="author"/>"/>
							</td>
							<td>
								<input name="title"  readonly="readonly" value="<s:property value="title"/>"/>
							</td>
							<td>
								<button type="submit" class="btn btn-primary">view</button>
							</td>
					</form>
					<br>
				</tr>
			</s:iterator>
		</tbody>
	</table>