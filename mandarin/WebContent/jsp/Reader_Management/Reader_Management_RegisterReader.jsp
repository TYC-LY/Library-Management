<!-- 模态框 RegisterReader -->
			<div class="modal fade" id="RegisterReader">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- 模态框头部 -->
						<div class="modal-header">
							<h4 class="modal-title">Register Reader</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- 模态框主体 -->
						<div class="modal-body">
							<form action="signup">

								<div class="form-group">
									<label for="username">username:</label> <input
										class="form-control" name="username" type="text"
										id="user-username" placeholder="username" required
										autofocus=""> <label for="email">email:</label> <input
										class="form-control" name="email" type="email" id="user-email"
										placeholder="email" required autofocus=""> <label
										for="password">password:</label> <input class="form-control"
										name="password" type="password" id="user-pass"
										placeholder="password" required autofocus=""> <label
										for="phoneNumber">phoneNumber:</label> <input
										class="form-control" name="phoneNumber" type="text"
										id="user-phoneNumber" placeholder="phoneNumber" required
										autofocus="">
								</div>

								<button class="btn btn-primary" type="submit">Register</button>
							</form>

							<s:property value="errorMessage" />
						</div>

						<!-- 模态框底部 -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>