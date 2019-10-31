<!-- 表单 Add Book -->
				<h2>Add book</h2>			
				<form action="BookManagement_Add_Books">
					<div class="form-group">
						<label for="ISBN">ISBN:</label>
						<input class="form-control" name="ISBN" type="text" placeholder="ISBN" required autofocus="" value="<s:property value="tempBook.ISBN"/>" >
						<label for="title">title:</label>
						<input class="form-control" name="title" type="text" placeholder="title" required autofocus="" value="<s:property value="tempBook.title"/>" >
						<label for="author">author:</label>
						<input class="form-control" name="author" type="text" placeholder="author" required autofocus="" value="<s:property value="tempBook.author"/>" >
						<label for="publisher">publisher:</label>
						<input class="form-control" name="publisher" type="text" placeholder="publisher" required autofocus="" value="<s:property value="tempBook.publisher"/>" >
						<label for="description">description:</label>
						<input class="form-control" name="description" type="text" placeholder="description" required autofocus="" value="<s:property value="tempBook.description"/>" >
						<label for="location_floor">location_floor:</label>
				        <select class="form-control" id="location_floor" name="location_floor">
				          <option value="1">1</option>
				          <option value="2">2</option>
				          <option value="3">3</option>
				          <option value="4">4</option>
				        </select>
				        <label for="location_stack">location_stack:</label>
				        <select class="form-control" id="location_stack" name="location_stack">
				          <option value="1">1</option>
				          <option value="2">2</option>
				          <option value="3">3</option>
				          <option value="4">4</option>
				        </select>
				        <label for="location_area">location_area:</label>
				        <select class="form-control" id="location_area" name="location_area">
				          <option value="1">1</option>
				          <option value="2">2</option>
				          <option value="3">3</option>
				          <option value="4">4</option>
				        </select>
						<label for="price">price:</label>
						<input class="form-control" name="price" type="text" placeholder="price" required autofocus="" value="<s:property value="tempBook.price"/>" >
						<label for="categoryNo">categoryNo:</label>
						<input class="form-control" name="categoryNo" type="text" placeholder="categoryNo" required autofocus="" >
						<input class="form-control" name="imagePath" type="hidden" value="<s:property value="tempBook.imagePath"/>">
					</div>
					
					<h1><p class="text-success"><s:property value="errorMessage"/></p></h1>
					
					<button class="btn btn-primary" name="submit" type="submit">Add</button>
				</form>