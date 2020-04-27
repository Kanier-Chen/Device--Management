package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.CustomerDAO;
import dm.dao.LoginDAO;
import dm.dao.RepairmanDAO;
import dm.entity.Register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("adminname");
		String pwd = request.getParameter("adminpwd");
		int level = Integer.parseInt(request.getParameter("adminlevel"));
		LoginDAO ldao=new LoginDAO();
		CustomerDAO cdao = new CustomerDAO();
		RepairmanDAO rdao = new RepairmanDAO();
		if(ldao.login(name, pwd, level)||cdao.login(name, pwd, level)||rdao.login(name, pwd, level)) {
			HttpSession session = request.getSession();
			int table = 0;
			if(ldao.login(name, pwd, level)) {
				int id = ldao.QueryByNameLogin(name);
				Register admin=new Register(id,name,pwd,level);
				session.setAttribute("admin", admin);
			}else if(cdao.login(name, pwd, level)) {
				int cid = cdao.QueryByNameCustomer(name);
				session.setAttribute("cid", cid);
				session.setAttribute("name", name);
				session.setAttribute("level", level);
				table = 1;
			}else {
				int rid = rdao.QueryByNameRepairman(name);
				session.setAttribute("rid", rid);
				session.setAttribute("name", name);
				session.setAttribute("level", level);
				table = 2;
			}
			
			session.setAttribute("table", table);
			//3.跳转
			response.sendRedirect("admin/default.jsp");
		}else {
			response.sendRedirect("Login.jsp");
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
