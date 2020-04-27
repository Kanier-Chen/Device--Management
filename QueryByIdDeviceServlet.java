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
 * Servlet implementation class QueryByIdDeviceServlet
 */
@WebServlet("/admin/QueryByIdDeviceServlet")
public class QueryByIdDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryByIdDeviceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int did=Integer.parseInt(request.getParameter("did"));
		int operate = Integer.parseInt(request.getParameter("operate"));
		int level = Integer.parseInt(request.getParameter("level"));
		DeviceDAO ddao = new DeviceDAO();
		Device device = ddao.QueryByIdDevice(did);
		//System.out.println(device.getDid());
		HttpSession session = request.getSession();
		session.setAttribute("device", device);
		session.setAttribute("level", level);
		if(operate == 1) {
			response.sendRedirect("adddev.jsp");
		}else {
			response.sendRedirect("descdev.jsp");
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
