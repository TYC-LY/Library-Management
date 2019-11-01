<h1>Result:</h1>

<h2 class="text-success"><s:property value="errorMessage"/></h2>

<h1>Add more Books:</h1>

<form action="BookManagement_Add_Books_Copy">
	<label for="book_copy_number">The number of the book that you want to add:</label>
	<input name="book_copy_number" />
	<button class="btn btn-primary" name="submit" type="submit">Add Copy</button>
</form>

<table class="table table-hover">
		<thead>
			<tr>
				<th>id</th>
				<th>BarCode</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="idList" >
			<script>
    function $(id) {
      return document.getElementById(id);
    }
    function textToImg<s:property value="idCopy"/>() {
      var len = 30;// 设置长度？？？
      var i = 0;
      var fontSize = 25;// 设置字号
      var fontWeight = 'bold';// 设置粗细
      var txt = $('txt<s:property value="idCopy"/>').value;// 取文本框的值
      var canvas = $('canvas<s:property value="idCopy"/>');
      if (len > txt.length) {
        len = txt.length;
      }
      canvas.width = fontSize * len;
      canvas.height = fontSize * (3 / 2)
        * (Math.ceil(txt.length / len) + txt.split('\n').length - 1);
      var context = canvas.getContext('2d');
      context.clearRect(0, 0, canvas.width, canvas.height);
      context.font = fontWeight + ' ' + fontSize + 'px sans-serif';
      context.textBaseline = 'top';
      canvas.style.display = 'none';
      console.log(txt.length);
      function fillTxt(text) {
        while (text.length > len) {
          var txtLine = text.substring(0, len);
          text = text.substring(len);
          context.fillText(txtLine, 0, fontSize * (3 / 2) * i++,
            canvas.width);
        }
        context.fillText(text, 0, fontSize * (3 / 2) * i, canvas.width);
      }
      var txtArray = txt.split('\n');
      for (var j = 0; j < txtArray.length; j++) {
        fillTxt(txtArray[j]);
        context.fillText('\n', 0, fontSize * (3 / 2) * i++, canvas.width);
      }
      var imageData = context.getImageData(0, 0, canvas.width, canvas.height);
      var img = $("img<s:property value="idCopy"/>");
      img.src = canvas.toDataURL("image/png");
    }
  </script>
				<tr>
						<td>
							<s:property value="idCopy"/>
						</td>
						<td>
							<!-- <img src="D:/barcode/<s:property value="idCopy"/>.jpg" width="300" height="50"> -->
							<img src="http://api.k780.com/?app=barcode.get&bc_text=<s:property value="idCopy"/>&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4" width="300" height="50">
						</td>
						<td>
							 <!-- <img src="D:/booklocation/<s:property value="idCopy"/>.png" width="300" height="50"> -->
							 <textarea id="txt<s:property value="idCopy"/>"><s:property value="location"/></textarea>
							  <button onclick="textToImg<s:property value="idCopy"/>();">generate</button>
							  <canvas id="canvas<s:property value="idCopy"/>" style="display:block"></canvas>
							  <div><img id="img<s:property value="idCopy"/>" style="border: 1px solid" /></div>
						</td>
				</tr>
			</s:iterator>
		</tbody>
</table>
