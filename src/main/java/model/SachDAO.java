package model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachDAO {
	//Chuỗi kết nối
		private String jdbcURL = "jdbc:mysql://localhost:3306/qlsach?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "123456";
	    
	    //Kết nối Cơ sở dữ liệu
	    public SachDAO() {}
	    protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    //Câu truy vấn
	    private static final String SELECT_ALL_PRODUCT = "select * from sach";
	    
	    //Lấy toàn bộ dữ liệu
	    public List < Sach > selectAllProduct() {
	    	//Tạo danh sách chứa dữ liệu
	        List < Sach > Sach = new ArrayList < > ();
	        //Lấy dữ liệu rồi add vào danh sách
	        try (Connection connection = getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) 
	        {
	            System.out.println(preparedStatement);

	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	                int masach = rs.getInt("masach");
	                String tensach = rs.getString("tensach");
	                String soluong = rs.getString("soluong");
	                String gia = rs.getString("gia");
	                Sach.add(new Sach(masach, tensach, soluong, gia));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return Sach;
	    }
	    
	    //Hiển thị lỗi
	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	    //Chức năng CREATE: Thêm dữ liệu
	    //Câu truy vấn
	    private static final String INSERT_PRODUCT_SQL = "INSERT INTO sach" + 
	    												"(tensach, soluong, gia)"
	    												+"VALUES (?, ?, ?);";
	    //Phương thức thêm dữ liệu
	    public void insertProduct(Sach Sach) throws SQLException {
	        System.out.println(INSERT_PRODUCT_SQL);
	        // câu lệnh try-with-resource sẽ tự động đóng kết nối.
	        try (Connection connection = getConnection(); 
	        	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) 
	        {
	            preparedStatement.setString(1, Sach.gettensach());
	            preparedStatement.setString(2, Sach.getsoluong());
	            preparedStatement.setString(3, Sach.getgia());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }
	    //Update sản phẩm
	    private static final String UPDATE_PRODUCT_SQL = "update sach set tensach=?,soluong=?, gia=? where masach=?;";
	    public boolean updateProduct(Sach Sach) throws SQLException {
	    	System.out.println(UPDATE_PRODUCT_SQL);
	    	boolean rowUpdated =false;
	    	try (Connection connection = getConnection(); 
	    	    PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
	    	    
	    	    try {
	    	    	//Sửa chuỗi UTF-8 nếu bị lỗi font
	    	        statement.setString(1, new String(Sach.gettensach().getBytes("UTF-8"), "UTF-8"));
	    	    } catch (UnsupportedEncodingException e) {
	    	        // Xử lý ngoại lệ ở đây, ví dụ: in ra thông báo lỗi
	    	        e.printStackTrace();
	    	    }
	    	    
	    	    statement.setString(2,Sach.getsoluong());
	    	    statement.setString(3, Sach.getgia());
	    	    statement.setInt(4, Sach.getmasach());

	    	    rowUpdated = statement.executeUpdate() > 0;
	    	} catch (SQLException e) {
	    	    // Xử lý ngoại lệ SQL, ví dụ: in ra thông báo lỗi hoặc ghi vào log
	    	    e.printStackTrace();
	    	}
	    	return rowUpdated;
	    }    
	    
	    //Xóa sản phẩm
	    private static final String DELETE_PRODUCT_SQL = "delete from sach where masach = ?;";
	    public void deleteProduct(int id) {
	    	try {
				Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);
				statement.setInt(1, id);
				statement.executeUpdate();
				//Dùng executeUpdate() vì khi xóa xong không cần dữ liệu trả về
			} catch (SQLException e) {
				printSQLException(e);
			}
	    }
	    
	    //Thêm sản phẩm có ảnh
	    public void insertProductImage(Sach Sach) throws SQLException {
	    	String sql = "INSERT INTO sach (tensach, soluong, gia, imagePath) VALUES (?, ?, ?, ?)";
	    	Connection connection = getConnection();
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	statement.setString(1, Sach.gettensach());
	    	statement.setString(2, Sach.getsoluong());
	    	statement.setString(3, Sach.getgia());
	    	statement.setString(4, Sach.getImagePath());
	    	statement.executeUpdate();
	    	statement.close();
	    }
}
