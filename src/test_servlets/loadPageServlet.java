package test_servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Order;

/**
 * Servlet implementation class loadPageServlet
 */
@WebServlet("/test")
public class loadPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test servlet");
		Order o=new Order("BUY", "Limit", null, 100, 152, 1, "pending", true);
		staticOrdersCl.addToList(o);
		List<Order> l=staticOrdersCl.getList();		
	
		request.setAttribute("order", l);
		RequestDispatcher dis=request.getRequestDispatcher("admin_test.jsp");
		dis.forward(request, response);
	}

}
