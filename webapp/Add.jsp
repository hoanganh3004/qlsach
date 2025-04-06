<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Thêm sinh viên</title>
	<style type="text/css">
		#btn{
			border: 1px solid #007BFF;
			border-radius: 5px;
			height: 40px;
			color: white;
			background: #007BFF;
		}
		#btn:hover{
			background: #75B43A;
		}
	</style>
</head>
<body>
	<h1>Thêm Sách</h1>
	<form action="AddSach" method="post" accept-charset="UTF-8">
		<label for="tensach">Tên sách:</label>
		<input type="text" name="tensach" required><br><br>
		
		<label for="soluong">Số lượng:</label>
		<input type="text" name="soluong" required><br><br>
		
		<label for="gia">giá:</label>
		<input type="text" name="gia" required><br><br>
		
		<input id="btn" type="submit" value="Thêm sách">
	</form>
</body>
</html>