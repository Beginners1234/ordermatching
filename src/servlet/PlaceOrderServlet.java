package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderTableImpl;
import DAO.UserTableImpl;
import businessLogic.OrderProcessesInterfaceImpl;
import pojo.Order;
import pojo.User;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/placeorder")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("./placeOrder.jsp");
        dispatcher.forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String orderType=request.getParameter("ordertypeml"); //mkt or lmt
		String buyorsell=request.getParameter("ordercatbs"); //buy or sell
		
		if(orderType.equalsIgnoreCase("lmt")) {
			orderType="LIMIT";		
		}else orderType="MARKET";
		
		String quantitybuystr=request.getParameter("quantitybuy") != null?request.getParameter("quantitybuy"):"0";
		String quantitysellstr=request.getParameter("quantitysell") != null?request.getParameter("quantitysell"):"0";
		String pricebuystr=request.getParameter("pricebuy") != null?request.getParameter("pricebuy"):"0";
		String pricesellstr=request.getParameter("pricesell") != null?request.getParameter("pricesell"):"0";
		System.out.println("price in serv  "+pricebuystr);
		double price=0;
		double quantity=0;
		String aon=null;
		if(buyorsell.equalsIgnoreCase("buy")) {
			quantity=Double.parseDouble(quantitybuystr);
			if(orderType.equalsIgnoreCase("market")) {
				price=1000;
			}else {
				price=Double.parseDouble(pricebuystr);
				aon=request.getParameter("aonbuy");
			}
		}else {//sell
			quantity=Double.parseDouble(quantitysellstr);
			if(orderType.equalsIgnoreCase("market")) {
				price=0;
			}else {
				price=Double.parseDouble(pricesellstr);
				aon=request.getParameter("aonsell");
			}
			
		}
		
		String loginid=request.getSession().getAttribute("loginId").toString();
		//get user id from db for username
		UserTableImpl uimpl=new UserTableImpl();
		List<User> list=uimpl.GetUserByLoginid(loginid);
		User user=list.get(0);
		double userid=user.getUserId();
		if(list.isEmpty()) {
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		boolean allornone=true;
		if(aon==null) {
			allornone=false;
		}
		
		Order order=new Order(buyorsell.toUpperCase(), orderType.toUpperCase(), new Date(), quantity, price, userid, "PENDING", allornone);
		OrderProcessesInterfaceImpl impl=new OrderProcessesInterfaceImpl();
		int resu=impl.PlaceOrder(order);
		System.out.println("got post order req");
		PrintWriter out = response.getWriter();
	     out.println("<h1>"+user+"<br> "+order+"<br> "+resu+ "</h1>");
		
		
	}

}
