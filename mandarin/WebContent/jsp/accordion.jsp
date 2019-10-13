
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
										<a href="/mandarin/jsp/Announcement_Management/Announcement_Management_Edit_Announcement_Main.jsp"><button type="button" class="btn btn-primary btn-block">Edit Announcement</button></a>
									</li>
									<br>
									<li class="nav-item">
										<!-- 按钮：用于打开链接 -->
										<a href="/mandarin/jsp/Announcement_Management/Announcement_Management_Delete_Announcement_Main.jsp"><button type="button" class="btn btn-primary btn-block">Delete Announcement</button></a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
