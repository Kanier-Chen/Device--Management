package dm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dm.dao.ProcessDAO;
import dm.dao.ProcessDAO;

/**
 * Servlet implementation class QueryProcessServlet
 */
@WebServlet("/admin/QueryProcessServlet")
public class QueryProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		ProcessDAO pdao = new ProcessDAO();
//		ArrayList list = pdao.QueryProcess();
//		HttpSession session = request.getSession();
//		session.setAttribute("list", list);
//		response.sendRedirect("processview.jsp");
		request.setCharacterEncoding("utf-8");
		ProcessDAO pdao = new ProcessDAO();
		int count = 5;	//每页显示的记录数 （可以修改此数据，让页面显示的每页记录数变化）9
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); //从外界获取当前页码
		int totalNum = 0; //总页数
		int totalcount = pdao.QueryProcess1().size();  //总记录数
		if(totalcount%count == 0 ) {
			totalNum = totalcount/count;
		}else {
			totalNum = totalcount/count + 1;
		}
		int begin = pageNum * count - (count-1);	//计算出当前页码所对应的数据记录的起始位置
		ArrayList list = pdao.QueryProcess(begin-1, count);//传入  数据库记录的起始位置
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		session.setAttribute("pageNum", pageNum); 	//会话保存界面页码
		session.setAttribute("totalNum", totalNum);
		session.setAttribute("totalcount", totalcount);
		session.setAttribute("count", count);
		response.sendRedirect("processview.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
