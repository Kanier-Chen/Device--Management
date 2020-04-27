package dm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.ComponentDAO;
import dm.dao.DeviceDAO;
import dm.dao.ProcessDAO;
import dm.entity.Device;
import dm.entity.Process;

/**
 * Servlet implementation class DealProcessServlet
 */
@WebServlet("/admin/DealProcessServlet")
public class DealProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("pid"));
		int rid = Integer.parseInt(request.getParameter("rid"));
		HttpSession session = request.getSession();
		ProcessDAO pdao = new ProcessDAO();
		Process process = pdao.QueryByIdProcess(pid);
		int did = process.getDid();
		DeviceDAO ddao = new DeviceDAO();
		Device device = ddao.QueryByIdDevice(did);
		String dname = device.getDname();
		session.setAttribute("pid", pid);
		session.setAttribute("rid", rid);
		session.setAttribute("dname", dname);
		ComponentDAO cdao = new ComponentDAO();
		ArrayList clist = cdao.QueryComponent1();
		session.setAttribute("clist", clist);
		response.sendRedirect("deal.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
