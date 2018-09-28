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
        HttpSession session = request.getSession();
		String loginId=(String)session.getAttribute("loginId");	
		if(!(loginId != null && !loginId.isEmpty())) {
        	request.setAttribute("errorString", "session expired");
        	//System.out.println("no session 1");
    		RequestDispatcher d=request.getRequestDispatcher("login.jsp");
    		d.forward(request, response);  
 
        }
		UserTableImpl a=new UserTableImpl();
		OrderProcessesInterfaceImpl b=new OrderProcessesInterfaceImpl();
		OrderTableImpl i=new OrderTableImpl();
		TradeTableImpl t=new TradeTableImpl();
		//HttpSession session=request.getSession();
		//RequestDispatcher d=request.getRequestDispatcher("login.jsp");
		//d.forward(request, response); 
//
//		Boolean check=session.getAttribute("loginId").equals("admin");
//		if(check==false)
//		{
//			RequestDispatcher d2=request.getRequestDispatcher("login.jsp");
//			d2.forward(request, response); 
//		}
//
//		
//		String loginId=(String)session.getAttribute("loginId");		
//		List<User>u=a.GetUserByLoginid(loginId);
//		User user=u.get(0);
//		System.out.println(u.get(0));
		int number_orders=b.GetStatistics("order");
		int number_trades=b.GetStatistics("trade");
		int number_users=b.GetStatistics("user");
		request.setAttribute("stats_order", number_orders);//attributes names
		request.setAttribute("stats_trade", number_trades);
		request.setAttribute("stats_user", number_users);
//		request.setAttribute("name", user.getName());
		List<Order>list_orders=i.GetAllOrders();
		ArrayList<Order> list_orders_buy = new ArrayList<>();
		ArrayList<Order> list_orders_sell = new ArrayList<>();
		for(int k=0; k<list_orders.size(); k++)
		{
			if(list_orders.get(k).getOrderCategory().equals("BUY"))
			{
				list_orders_buy.add(list_orders.get(k));
			}
			else if(list_orders.get(k).getOrderCategory().equals("SELL"))
			{
				list_orders_sell.add(list_orders.get(k));
			}
		}
		List<Trade>list_trades=t.GetAllTrades();
		System.out.println(list_trades);
	    request.setAttribute("buy_order",list_orders_buy);
	    request.setAttribute("sell_order",list_orders_sell);
		request.setAttribute("trade_order",list_trades);
		RequestDispatcher d1=request.getRequestDispatcher("index2.jsp");
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
