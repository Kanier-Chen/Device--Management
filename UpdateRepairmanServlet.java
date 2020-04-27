package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dm.dao.RepairmanDAO;

/**
 * Servlet implementation class UpdateRepairmanServlet
 */
@WebServlet("/admin/UpdateRepairmanServlet")
public class UpdateRepairmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRepairmanServlet() {
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
		String rname = request.getParameter("rname");
		String rpwd = request.getParameter("rpwd");
		String rtel = request.getParameter("rtel");
		RepairmanDAO rdao = new RepairmanDAO();
		rdao.UpdateRepairman(rid, rname, rpwd, rtel);
		response.sendRedirect("QueryRepairmanServlet?pageNum=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
