package dm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.DeviceDAO;

/**
 * Servlet implementation class AddstockDeviceServlet
 */
@WebServlet("/admin/AddstockDeviceServlet")
public class AddstockDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddstockDeviceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int level = Integer.parseInt(request.getParameter("level"));
		int did=Integer.parseInt(request.getParameter("did"));
		int dstock = Integer.parseInt(request.getParameter("dstock"));
		DeviceDAO ddao = new DeviceDAO();
		ddao.AddstockDevice(did, dstock);		
		HttpSession session = request.getSession();
		session.setAttribute("level", level);
		response.sendRedirect("QueryDeviceServlet1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
