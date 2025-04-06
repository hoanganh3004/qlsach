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
 * Servlet implementation class AddSach
 */
@WebServlet("/AddSach")
public class AddSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSach() {
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
		request.setCharacterEncoding("UTF-8");
        String tensach = request.getParameter("tensach");
        String soluong = request.getParameter("soluong");
        String gia = request.getParameter("gia");
        Sach Sach = new Sach(tensach, soluong, gia);
        try {
        	SachDAO.insertProduct(Sach);
            response.sendRedirect("ShowSach");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
