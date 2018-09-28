package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderTableImpl;
import DAO.UserTableImpl;
import pojo.Order;
import pojo.User;

/**
 * Servlet implementation class OpenUserOrdersServlet
 */
@WebServlet("/userorder")
public class OpenUserOrdersServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenUserOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("user order servlet");
		
		HttpSession session=request.getSession();
		String loginId=(String)session.getAttribute("loginId");
		UserTableImpl u=new UserTableImpl();
		List<User>us=u.GetUserByLoginid(loginId);
		User user=us.get(0);
	    OrderTableImpl o=new OrderTableImpl();
	    List<Order>orders= o.GetOrderByUserId(user.getUserId(),100);
	    request.setAttribute("allOrders", orders);
	    request.setAttribute("name", user.getName());
        RequestDispatcher dispatcher= request.getRequestDispatcher("orderhistory.jsp");
        dispatcher.forward(request, response);
		
	}

}
