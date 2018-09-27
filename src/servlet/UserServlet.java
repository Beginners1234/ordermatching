package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderTableImpl;
import DAO.TradeTableImpl;
import DAO.UserTableImpl;
import businessLogic.OrderProcessesInterfaceImpl;
import pojo.Order;
import pojo.Trade;
import pojo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserTableImpl a=new UserTableImpl();
		OrderProcessesInterfaceImpl b=new OrderProcessesInterfaceImpl();
		OrderTableImpl i=new OrderTableImpl();
		TradeTableImpl t=new TradeTableImpl();
		HttpSession session=request.getSession();
		String loginId=(String)session.getAttribute("loginId");
		
		Double loginID=Double.parseDouble(loginId);
		
		List<User>u=a.GetUserByUsername(loginID);
		User user=u.get(0);
		int number_orders=b.GetStatisticsUser(user.getUserId(),"order");
		int number_trades=b.GetStatisticsUser(user.getUserId(),"trade");
		int number_position=b.GetStatisticsUser(user.getUserId(), "positon");
		request.setAttribute("statistics_order", number_orders);
		request.setAttribute("statistics_trade", number_trades);
		request.setAttribute("statistics_position", number_position);
		int n=20;
		List<Order>list_orders=i.GetOrderByUserId(user.getUserId(),n);
		List<Trade>list_trades=t.GetTradesByUserId(user.getUserId(),n);
	    request.setAttribute("list_orders",list_orders);
		request.setAttribute("list_trades",list_trades);
		RequestDispatcher d=request.getRequestDispatcher("user.jsp");
		d.forward(request, response);  
		
	}

}
