package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserTableImpl a=new UserTableImpl();
		OrderProcessesInterfaceImpl b=new OrderProcessesInterfaceImpl();
		OrderTableImpl i=new OrderTableImpl();
		TradeTableImpl t=new TradeTableImpl();
		System.out.println("Hello");
		HttpSession session=request.getSession();
		
		String loginId = "admin";
	//	Boolean check=session.getAttribute("loginId").equals("admin");
/*//		if(check==false)
//		{
//			RequestDispatcher d=request.getRequestDispatcher("/pages/examples/login.jsp");
//			d.forward(request, response); 
//		}

		
//		String loginId=(String)session.getAttribute("loginId");		
*/		List<User>u=a.GetUserByLoginid(loginId);
		User user=u.get(0);
		System.out.println(u.get(0));
		int number_orders=b.GetStatistics("order");
		int number_trades=b.GetStatistics("trade");
		int number_users=b.GetStatistics("user");
		System.out.println(number_orders+ number_trades+ number_users);
		request.setAttribute("stats_order", number_orders);//attributes names
		request.setAttribute("stats_trade", number_trades);
		request.setAttribute("stats_user", number_users);
		request.setAttribute("name", user.getName());
		List<Order>list_orders=i.GetAllOrders();
		System.out.println(list_orders);
		List<Order> list_orders1=new ArrayList<>();
		for(int ii=0;ii<1;ii++)
		{
			list_orders1.set(ii, list_orders.get(ii)); 
		}
		System.out.println(list_orders1);
		List<Trade>list_trades=t.GetAllTrades();
		System.out.println(list_trades);
		List<Trade> list_trades1=new ArrayList<>();
		for(int ii=0;ii<1;ii++)
		{
			list_trades1.set(ii, list_trades.get(ii)); 
		}
		System.out.println(list_trades1);
	    request.setAttribute("list_orders",list_orders1);
		request.setAttribute("list_trades",list_trades1);
//		RequestDispatcher d=request.getRequestDispatcher("index2_admin.jsp");//put admin html page name
//		d.forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
