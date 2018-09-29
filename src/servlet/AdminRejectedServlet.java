package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderTableImpl;
import pojo.Order;

/**
 * Servlet implementation class AdminRejectedServlet
 */
@WebServlet("/ars")
public class AdminRejectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRejectedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String loginId=(String)session.getAttribute("loginId");	
		if(!(loginId != null && !loginId.isEmpty())) {
        	request.setAttribute("errorString", "session expired");
        	//System.out.println("no session 1");
    		RequestDispatcher d=request.getRequestDispatcher("login.jsp");
    		d.forward(request, response);  
    		return;
 
        }
		
		if(!Objects.equals(loginId, "admin"))
		{
//			System.out.println("entered check\n\n");
			request.setAttribute("errorString", "You're not an admin. Login Again.");
			session.invalidate();	           
			RequestDispatcher d=request.getRequestDispatcher("login.jsp");
    		d.forward(request, response);  
    		return;
		}
	
		OrderTableImpl o = new OrderTableImpl();
		List<Order>list_orders_rejected = o.GetAllOrders("REJECTED");
		request.setAttribute("name", loginId);
		request.setAttribute("order_rejected",list_orders_rejected);
		RequestDispatcher d1=request.getRequestDispatcher("rejectedorders.jsp");
		d1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
