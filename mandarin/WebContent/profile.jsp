<form class="form-inline" action="reader-search">
						<!-- <div class="form-group">
							<input class="form-control mr-sm-2" name="searchContent" type="text" placeholder="Search" aria-label="Search" autocomplete="off">
							<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search By</button>
							<select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
							    <option value="title">Book Title</option>
							    <option value="author">Author</option>
							    <option value="publisher">Publisher</option>
							    <option value="isbn">ISBN</option>
							</select>
						</div> -->
						<div class="input-group-append">
						    	<select class="rounded-left" id="inlineFormCustomSelect">
								    <option value="title">Book Title</option>
								    <option value="author">Author</option>
								    <option value="publisher">Publisher</option>
								    <option value="isbn">ISBN</option>
								</select>
								<input type="text" class="form-control rounded-0" name="searchContent" aria-label="Input some information of the book you want">
						        <button type="submit" class="btn btn-outline-primary rounded-right">Search By</button>
						</div>
					</form>