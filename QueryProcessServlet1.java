package dm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.CustomerDAO;
import dm.dao.LoginDAO;
import dm.dao.ProcessDAO;
import dm.entity.Customer;
import dm.entity.Register;

/**
 * Servlet implementation class QueryProcessServlet1
 */
@WebServlet("/admin/QueryProcessServlet1")
public class QueryProcessServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProcessServlet1() {
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
		String name = register.getName();
		CustomerDAO cdao =new CustomerDAO();
		int cid = cdao.QueryByNameCustomer(name);
		ProcessDAO pdao = new ProcessDAO();
		HttpSession session = request.getSession();
		ArrayList list1 = pdao.QueryProcess0(cid);
		session.setAttribute("list1", list1);
		response.sendRedirect("apply.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
