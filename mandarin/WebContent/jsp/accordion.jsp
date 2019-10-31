
				<!-- 手风琴界面 -->
				<div id="accordion">
					<div class="card">
						<div class="card-header">
							<a class="card-link" data-toggle="collapse" href="#collapseOne">
								Reader Management </a>
						</div>
						<div id="collapseOne" class="collapse show"
							data-parent="#accordion">
							<div class="card-body">
								<ul class="nav nav-pills flex-column">
									<li class="nav-item">
										<!-- 按钮：用于打开模态框 -->
										<button type="button" class="btn btn-primary btn-block"
											data-toggle="modal" data-target="#RegisterReader">Register
											Reader</button>
									</li>
									<br>
									<li class="nav-item">
										<!-- 按钮：用于打开模态框 -->
										<a href="/mandarin/jsp/Reader_Management/Reader_Management_SearchReader_Main.jsp">
										<button type="button" class="btn btn-primary btn-block">
											Edit Reader
										</button>
									</li>
									<br>
									<li>
										<a href="/mandarin/jsp/Reader_Management/Reader_Management_ReaderHistory_Main.jsp">
											<button class="btn btn-primary btn-block">Reader History</button>
										</a>
									</li>
								</ul>

							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header">
							<a class="collapsed card-link" data-toggle="collapse"
								href="#collapseTwo"> Book Management </a>
						</div>
						<div id="collapseTwo" class="collapse" data-parent="#accordion">
							<div class="card-body">
								<ul class="nav nav-pills flex-column">
									<li class="nav-item">
										<!-- 按钮：用于打开模态框 -->
										<button type="button" class="btn btn-primary btn-block"
											data-toggle="modal" data-target="#AddBook">Add Book</button>
									</li>
									<br>
									
									<li>
										<a href="/mandarin/jsp/Book_Management/Book_Management_Delete_Books_Main.jsp">
											<button class="btn btn-primary btn-block">Delete Book</button>
										</a>
									</li>
									<br>
									
									<li class="nav-item">
										<!-- 按钮：用于打开链接 -->
										<a href="/mandarin/jsp/Book_Management/Book_Management_Edit_Books_Main.jsp">
												<button type="button" class="btn btn-primary btn-block">Edit Book</button>
										</a>
									</li>
									<br>
									<li class="nav-item">
										<!-- 按钮：用于打开链接 -->
										<form action="viewDeletionRecord">
											<a href="/mandarin/jsp/Book_Management/Book_Management_Delete_Books_DeltionRecord_Main.jsp">
												<button type="submit" class="btn btn-primary btn-block">Book Deletion Record</button>
											</a>
										</form>
									</li>
									<br>
								</ul>

							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header">
							<a class="collapsed card-link" data-toggle="collapse"
								href="#collapseThree"> Announcement Management </a>
						</div>
						<div id="collapseThree" class="collapse" data-parent="#accordion">
							<div class="card-body">
								<ul class="nav nav-pills flex-column">
									<li class="nav-item">
										<!-- 按钮：用于打开模态框 -->
										<button type="button" class="btn btn-primary btn-block"
											data-toggle="modal" data-target="#AddAnnouncement">Add Announcement</button>
									</li>
									<br>
									<li class="nav-item">
										<!-- 按钮：用于打开链接 -->
										<a href="/mandarin/jsp/Announcement_Management/Announcement_Management_Edit_Announcement_Main.jsp">
											<form action="viewAnnouncements_Edit">
												<button type="submit" class="btn btn-primary btn-block">Edit Announcement</button>
											</form>
										</a>
									</li>
									<br>
									<li class="nav-item">
										<!-- 按钮：用于打开链接 -->
										<a href="/mandarin/jsp/Announcement_Management/Announcement_Management_Delete_Announcement_Main.jsp">
											<form action="viewAnnouncements_Delete">
												<button type="submit" class="btn btn-primary btn-block">Delete Announcement</button>
											</form>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header">
							<a class="card-link" data-toggle="collapse"
								href="#collapseFour">Lend Book or Return Book
							</a>
						</div>
						<div id="collapseFour" class="collapse show"
							data-parent="#accordion">
							<div class="card-body">
								<ul class="nav nav-pills flex-column">
									<li class="nav-item">
										<!-- 按钮：用于打开链接 -->
										<a href="/mandarin/jsp/Lend_Book_Return_Book/Lend_Book.jsp">
												<button class="btn btn-primary btn-block">Lend Book</button>
										</a>
									</li>
									<br>
									<li class="nav-item">
										<!-- 按钮：用于打开链接 -->
										<a href="/mandarin/jsp/Lend_Book_Return_Book/Return_Book.jsp">
												<button class="btn btn-primary btn-block">Return Book</button>
										</a>
									</li>
								</ul>

							</div>
						</div>
					</div>
					<div class="card">
						<div class="card-header">
							<a class="card-link" data-toggle="collapse"
								href="#collapseFive">View Library Income History
							</a>
						</div>
						<div id="collapseFive" class="collapse"
							data-parent="#accordion">
							<div class="card-body">
								<ul class="nav nav-pills flex-column">
									<li class="nav-item">
										<!-- 按钮：用于打开链接 -->
										<a href="/mandarin/jsp/View_Library_Income_History/View_Library_Income_History_Main.jsp">
												<button class="btn btn-primary btn-block">View Library Income History</button>
										</a>
									</li>
								</ul>

							</div>
						</div>
					</div>
					
				</div>
