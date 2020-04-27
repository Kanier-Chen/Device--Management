package dm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.ProcessDAO;
import dm.dao.RepairmanDAO;
import dm.entity.Repairman;

/**
 * Servlet implementation class QueryProcessServlet22
 */
@WebServlet("/admin/QueryProcessServlet22")
public class QueryProcessServlet22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProcessServlet22() {
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
		String rname = repairman.getRname();
		ProcessDAO pdao = new ProcessDAO();
		ArrayList list = pdao.QueryProcess3(rname);
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		session.setAttribute("rname", rname);
		response.sendRedirect("applydeal.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
