package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dm.dao.ComponentDAO;
import dm.dao.CustomerDAO;
import dm.dao.DeviceDAO;
import dm.dao.ProcessDAO;
import dm.dao.RepairmanDAO;
import dm.entity.Repairman;

/**
 * Servlet implementation class AddProcessServlet2
 */
@WebServlet("/admin/AddProcessServlet2")
public class AddProcessServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProcessServlet2() {
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
		int pop = Integer.parseInt(request.getParameter("pop"));
		String pstate = request.getParameter("pstate");
		String pdate = request.getParameter("pdate");
		int pmoney = Integer.parseInt(request.getParameter("pmoney"));
		int rid = Integer.parseInt(request.getParameter("rid"));
		ProcessDAO pdao = new ProcessDAO();
		if(pop==1) {
			ComponentDAO cdao = new ComponentDAO();
			int coid = cdao.QueryByNameComponent(pstate);
			cdao.DescstockComponent(coid, 1);
			pdao.Add4Process(pid,pstate,pdate,pmoney,rid,coid);
		}else {
			DeviceDAO ddao = new DeviceDAO();
			int did = ddao.QueryByNameDevice(pstate);
			ddao.DescstockDevice(did, 1);
			pdao.Add2Process(pid,pstate,pdate,pmoney,rid);
		}
		response.sendRedirect("QueryProcessServlet4");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
