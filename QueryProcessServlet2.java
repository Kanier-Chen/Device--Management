package dm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.LoginDAO;
import dm.dao.ProcessDAO;
import dm.dao.RepairmanDAO;
import dm.entity.Register;
import dm.entity.Repairman;

/**
 * Servlet implementation class QueryProcessServlet2
 */
@WebServlet("/admin/QueryProcessServlet2")
public class QueryProcessServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProcessServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		LoginDAO ldao = new LoginDAO();
		Register register = ldao.QueryByIdLogin(id);
		String rname = register.getName();
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
