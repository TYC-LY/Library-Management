<script language="JavaScript">
	var FineV;
	/* *"^-?\\d+$" 整数
	 * "^\\d+$"   非负整数
	 *  "^[0-9]*[1-9][0-9]*$"正整数
	 */

	function rightFineValue() {
		var FineV1 = document.getElementsByName("FineValue")[0];
		wdiv = document.getElementById("rightV");
		var text = FineV1.value;

		if (text == "") {
			wdiv.innerHTML = "<font color='red'>Input can not be blank</font>";
			FineV = 1;
		}

		else if (text.match("^-?\\d+$") == null) {
			wdiv.innerHTML = "<font color='red'>The current input is a non-integer</font>";
			FineV = 1;
		} else {
			if (text.match("^[0-9]*[1-9][0-9]*$") == null) {

				wdiv.innerHTML = "<font color='red'>The current input is a non-positive integer</font>";
				FineV = 1;
			} else {
				wdiv.innerHTML = "<font color='greed'></font>";
				FineV = 0;
			}

		}
		if (FineV == 0) {
			var aaa = document.getElementById("from");
			aaa.action = "modifyFine";
			aaa.submit();
		}

	}
</script>
<!-- 模态框 FineValue -->
<div class="modal fade" id="FineValue">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- 模态框头部 -->
			<div class="modal-header">
				<h3 class="modal-title">Modify overdue fine</h3>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- 模态框主体 -->
			<div class="modal-body" style="height: 150px">

				<h5 align="center">
					<font color="#6600CC">Fine value is a positive integer</font>
				</h5>
				<br>
				<div align="center">
					<form method="POST" id="from">
						<tr>
							<td>fine value</td>
							<td><input type="text" name="FineValue" wide="10"
								placeholder="yuan" /> <span id="rightV"></span></td>
						</tr>
						<br> <br> 
						<input type="button"
							class="layui-btn layui-btn layui-btn-sm" value="submit"
							onclick="rightFineValue()"> 
							<br>
					</form>
				</div>

			</div>

			<!-- 模态框底部 -->
			<div class="modal-footer">
				
				<a href="javascript:location.reload();"
				type="button" class="layui-btn layui-btn-primary layui-btn-sm" >cancle</a>
		</div>
	</div>
</div>