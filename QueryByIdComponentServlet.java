package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.ComponentDAO;
import dm.entity.Component;

/**
 * Servlet implementation class QueryByIdComponentServlet
 */
@WebServlet("/admin/QueryByIdComponentServlet")
public class QueryByIdComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryByIdComponentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int coid=Integer.parseInt(request.getParameter("coid"));
		int operate = Integer.parseInt(request.getParameter("operate"));
		int level = Integer.parseInt(request.getParameter("level"));
		ComponentDAO cdao = new ComponentDAO();
		Component component = cdao.QueryByIdComponent(coid);
		HttpSession session = request.getSession();
		session.setAttribute("component", component);
		session.setAttribute("level", level);
		if(operate == 1) {
			response.sendRedirect("addcomp.jsp");
		}else {
			response.sendRedirect("desccomp.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
