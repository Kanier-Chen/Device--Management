package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.CustomerDAO;
import dm.dao.DeviceDAO;
import dm.dao.ProcessDAO;
import dm.dao.RepairmanDAO;

/**
 * Servlet implementation class UpdateProcessServlet
 */
@WebServlet("/admin/UpdateProcessServlet")
public class UpdateProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String cname = request.getParameter("cname");
		String dname = request.getParameter("dname");
		String fdate = request.getParameter("fdate");
		CustomerDAO cdao = new CustomerDAO();
		int cid = cdao.QueryByNameCustomer(cname);
		DeviceDAO ddao = new DeviceDAO();
		int did = ddao.QueryByNameDevice(dname);
		ProcessDAO pdao = new ProcessDAO();
		pdao.UpdateProcess(pid, did,fdate);
		HttpSession session = request.getSession();
		session.setAttribute("cid", cid);
		response.sendRedirect("QueryProcessServlet3");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
