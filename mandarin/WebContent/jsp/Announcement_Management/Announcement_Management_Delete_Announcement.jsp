<!-- col-sm-8 Delete Announcement -->
<h1>Delete Announcement</h1>
<p>
	<form action="viewAnnouncements_Delete">
		<button type="submit" class="btn btn-primary" >Refresh</button>
	</form>
</p>
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
					<form action="deleteAnnouncement">
						<td>
							<input name="id" readonly="readonly" value="<s:property value="id"/>"/>
						</td>
						<td>
							<input name="author" readonly="readonly" value="<s:property value="author"/>"/>
						</td>
						<td>
							<input name="title"  readonly="readonly" value="<s:property value="title"/>"/>
						</td>
						<td>
							<button type="submit" class="btn btn-primary" >delete</button>
						</td>
					</form>				
					<br>
				</tr>
			</s:iterator>
		</tbody>
	</table>