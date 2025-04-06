<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Product Detail</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Product Detail</h1>
		<%
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				// Lấy ID sản phẩm từ URL
				String id = request.getParameter("masach");
				// Kết nối đến cơ sở dữ liệu
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsach", "root","123456");
				
				// Truy vấn sản phẩm dựa trên ID
				stmt = conn.prepareStatement("SELECT * FROM sach WHERE masach = ?");
				stmt.setInt(1, Integer.parseInt(id));
				rs = stmt.executeQuery();
				if (rs.next()) {
				
				// Lấy thông tin sản phẩm từ ResultSet
				String tensach = rs.getString("tensach");
				int soluong = rs.getInt("soluong");
				double gia = rs.getDouble("gia");
				String imagePath = rs.getString("imagePath");
				// Hiển thị thông tin sản phẩm lên trang web
			
			%>
			<div class="row">
				<div class="col-md-4">
					<img src="<%= imagePath %>" class="img-fluid">
				</div>
				<div class="col-md-8">
					<h2><%= tensach %></h2>
					<p>soluong: <%= soluong %></p>
					<p>gia: <%= gia %></p>
				</div>
			</div>
			
			<%
			
			} else {
			// Không tìm thấy sản phẩm
			
			%>
			
			<p>Product not found.</p>
			
			<%
		
			}
		} catch (SQLException e) {
			// Xử lý lỗi kết nối cơ sở dữ liệu
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// Xử lý lỗi không tìm thấy driver JDBC
			e.printStackTrace();
		} finally {
			// Đóng kết nối đến cơ sở dữ liệu
			try { if (rs != null) rs.close(); } catch (Exception e) {};
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
			try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
		%>
	</div>
</body>
</html>