package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.ComponentDAO;

/**
 * Servlet implementation class AddstockComponentServlet
 */
@WebServlet("/admin/AddstockComponentServlet")
public class AddstockComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddstockComponentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int level = Integer.parseInt(request.getParameter("level"));
		int coid=Integer.parseInt(request.getParameter("coid"));
		int costock = Integer.parseInt(request.getParameter("costock"));
		ComponentDAO cdao = new ComponentDAO();
		cdao.AddstockComponent(coid, costock);
		HttpSession session = request.getSession();
		session.setAttribute("level", level);
		response.sendRedirect("QueryComponentServlet1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
