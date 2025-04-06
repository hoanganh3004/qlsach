package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SachDAO;
import model.Sach;

/**
 * Servlet implementation class UpdateSach
 */
@WebServlet("/UpdateSach")
public class UpdateSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private SachDAO SachDAO;

    public void init() {
    	SachDAO = new SachDAO();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Đảm bảo giá trị nhận được là UTF-8
		request.setCharacterEncoding("UTF-8");
		//Lấy các thông tin từ HTTP
		String masachParam = request.getParameter("masach");
		int masach = Integer.parseInt(masachParam.trim());
		String tensach = request.getParameter("tensach");
        String soluong = request.getParameter("soluong");		        
        String gia = request.getParameter("gia");		      
        
     // Lấy sản phẩm cần cập nhật từ cơ sở dữ liệu bằng ID
        Sach newSach = new Sach(masach,tensach, soluong, gia);
        boolean rowUpdated = false;
        try {
        	rowUpdated = SachDAO.updateProduct(newSach);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
     // Kiểm tra kết quả cập nhật và chuyển hướng người dùng
        if (rowUpdated) {
            // Cập nhật thành công, có thể chuyển hướng người dùng đến trang thông báo thành công hoặc trang khác
        	response.sendRedirect("ShowSach");
        } else {
            // Cập nhật thất bại, có thể chuyển hướng người dùng đến trang thông báo lỗi hoặc trang khác
            response.sendRedirect("error.jsp");
        }
	}
}
