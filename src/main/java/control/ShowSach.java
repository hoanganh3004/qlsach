package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SachDAO;
import model.Sach;

/**
 * Servlet implementation class ShowSach
 */
@WebServlet("/ShowSach")
public class ShowSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SachDAO SachDAO;

    public void init() {
    	SachDAO = new SachDAO();
    }  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List < Sach > listSach = SachDAO.selectAllProduct();
        request.setAttribute("listSach", listSach);
        //Danh sach sản phẩm được lưu vào listProduct và truyền vào trang show-product.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("Show.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
