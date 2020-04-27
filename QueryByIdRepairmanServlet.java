package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.RepairmanDAO;
import dm.entity.Repairman;

/**
 * Servlet implementation class QueryByIdRepairmanServlet
 */
@WebServlet("/admin/QueryByIdRepairmanServlet")
public class QueryByIdRepairmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryByIdRepairmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int rid = Integer.parseInt(request.getParameter("rid"));
		RepairmanDAO rdao = new RepairmanDAO();
		Repairman repairman = rdao.QueryByIdRepairman(rid);
		HttpSession session = request.getSession();
		session.setAttribute("repairman", repairman);
		response.sendRedirect("updaterepairman.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
