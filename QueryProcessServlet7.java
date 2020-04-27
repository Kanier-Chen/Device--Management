package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.DeviceDAO;
import dm.entity.Device;

/**
 * Servlet implementation class QueryProcessServlet7
 */
@WebServlet("/admin/QueryProcessServlet7")
public class QueryProcessServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProcessServlet7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid =Integer.parseInt(request.getParameter("pid"));
		int did =Integer.parseInt(request.getParameter("did"));
		int cid =Integer.parseInt(request.getParameter("cid"));
		DeviceDAO ddao =new DeviceDAO();
		Device device = ddao.QueryByIdDevice(did);
		String dname = device.getDname();
		HttpSession session = request.getSession();
		session.setAttribute("pid", pid);
		session.setAttribute("dname", dname);
		session.setAttribute("cid",cid);
		response.sendRedirect("evaluate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
