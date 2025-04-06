<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Sách</title>
	<!-- Đường dẫn đến các tệp CSS và JavaScript của Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<h3 style="text-align: center;">Danh sách sách</h3>
  <div style="width: 600px;margin: 0 auto;">
  	<div>
  		<a href="Add.jsp">Thêm sách</a> |
  	</div>
	<div>
		<label>Tìm kiếm sách</label>
		<input type="text" id="searchBox" onkeyup="search()" placeholder="Tìm kiếm theo tên sách" style="width:100%;">
	</div>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>mã sách</th>
          <th>tên sách </th>
          <th>số lượng</th>
          <th>giá</th>
          <th colspan="2">Chức năng</th>
        </tr>
      </thead>
      <tbody>
      <!-- Để sử dụng thẻ c:... cần thêm thư viện jstl -->
      	<c:forEach var="listsv" items="${listSach}">
		        <tr>
		          	<td style="text-align: center;"><c:out value="${listsv.masach}" /></td>
		          	<!-- Sửa lại dòng bên dưới để trỏ đến trang chi tiết sản phẩm -->
	                <td><a href="Sach.jsp?masach=${listsv.masach}"><c:out value="${listsv.tensach}" /></a></td>
	                <td style="text-align: center;"><c:out value="${listsv.soluong}" /></td>
	                <td><c:out value="${listsv.gia}" /></td>
	                <td><a href="update.jsp?masach=${listsv.masach}
	                								&tensach=${listsv.tensach}
	                								&soluong=${listsv.soluong}
	                								&gia=${listsv.gia}">Sửa</a></td>
	                <!-- Các biến với giá trị tương ứng sẽ được truyền sang trang update-product.jsp -->
	                <td><a href="DeleteSach?idSach=${listsv.masach}">Xóa</a></td>
	                <!-- Biến idProduct sẽ được truyền vào servlet DeleteProductServlet -->
		        </tr>
        </c:forEach>
      </tbody>
    </table>

	<hr>
    
  </div>
	
	<script>
	  function filterProducts() {
	    var table, rows, price, minPrice, maxPrice, i, j;
	    table = document.getElementsByTagName("table")[0];
	    rows = table.getElementsByTagName("tr");
	    minPrice = parseInt(document.getElementById("minPrice").value);
	    maxPrice = parseInt(document.getElementById("maxPrice").value);
	
	    for (i = 1; i < rows.length; i++) {
	      price = parseInt(rows[i].getElementsByTagName("td")[3].innerHTML);
	      if (price < minPrice || price > maxPrice) {
	        rows[i].style.display = "none";
	      } else {
	        rows[i].style.display = "";
	      }
	    }
	  }
	</script>
  
  	<script>
	  function search() {
		  // Lấy giá trị của ô tìm kiếm
		  var searchValue = document.getElementById("searchBox").value.toLowerCase();
	
		  // Lặp qua tất cả các hàng trong bảng
		  var rows = document.getElementsByTagName("tr");
		  for (var i = 0; i < rows.length; i++) {
		    // Lấy giá trị của ô nameProduct trong hàng đó
		    var nameProduct = rows[i].getElementsByTagName("td")[1];
		    if (nameProduct) {
		      var nameProductValue = nameProduct.textContent.toLowerCase() || nameProduct.innerText.toLowerCase();
		      // Kiểm tra xem giá trị của ô nameProduct có chứa giá trị tìm kiếm hay không
		      if (nameProductValue.indexOf(searchValue) > -1) {
		        rows[i].style.display = "";
		      } else {
		        rows[i].style.display = "none";
		      }
		    }
		  }
		}
	</script>
</body>
</html>