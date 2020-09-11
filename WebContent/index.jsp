<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		//第一次讀取
		$returntrue = cartnumber();
		//自動更新
		if ($returntrue) {
			setInterval(function() {
				cartnumber();
			}, 10000); //預設10000毫秒自動重複執行cartnumber()函數
		}

		function cartnumber() {
			var url = "get_Msg";
			$.ajax({
				type : 'get',
				url : url,
				dataType : 'json',
				success : function(data) {

					$.each(data, function(i, list) {
						var _tr = $("<tr><td>" + list.message + "</td></tr>");

						$("#showTable").append(_tr);

					})
				},
				error : function() {

					console.log('ajax error!');

				}

			})

		}
		return true;
	});
</script>




<style>
body {
	margin-top: 20px;
}
div{
margin:5px;
}
</style>


</head>
<body>




	<div class="container-fluid">

		<div>
			<table id="showTable" border="1">
				<tr>
					<td><h3>訊息:</h3></td>
				</tr>
			</table>
		</div>
		<div>

			<form action="new_Msg" method="get">
				<textarea rows="4" cols="60" name="msg" required></textarea>
				<button type="submit">送出</button>
			</form>

		</div>

	</div>



</body>
</html>