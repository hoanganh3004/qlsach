<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Cập nhật thông tin sinh viên</title>
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
	<h1>Sửa thông tin sách</h1>	
	<form action="UpdateSach" method="post" accept-charset="UTF-8">
		<label for="masach">Mã Sách:</label>
		<input type="text" name="masach" value="<%= request.getParameter("masach") %>" readonly><br><br>
		<label for="tensach">Tên sách:</label>
		<input type="text" name="tensach" value="<%= request.getParameter("tensach") %>" required><br><br>
		
		<label for="soluong">Số lượng:</label>
		<input type="text" name="soluong" value="<%= request.getParameter("soluong") %>" required><br><br>
		
		<label for="gia">Giá:</label>
		<input type="text" name="gia" value="<%= request.getParameter("gia") %>" required><br><br>
		
		<input id="btn" type="submit" value="Cập nhật thông tin sách">
	</form>
</body>
</html>