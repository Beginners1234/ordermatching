package test_servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserTableImpl;
import businessLogic.OrderProcessesInterfaceImpl;
import pojo.Order;
import pojo.User;

/**
 * Servlet implementation class manualOrderServlet
 */
@WebServlet("/manAdd")
public class manualOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manualOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("\nManual order servlet called");
		// TODO Auto-generated method stub
		String orderType=request.getParameter("ordertypeml"); //mkt or lmt
		String buyorsell=request.getParameter("ordercatbs"); //buy or sell
		
		if(orderType.equalsIgnoreCase("lmt")) {
			orderType="LIMIT";		
		}else orderType="MARKET";
		
		String quantitybuystr=request.getParameter("quantitybuy") != null?request.getParameter("quantitybuy"):"0";
		String quantitysellstr=request.getParameter("quantitysell") != null?request.getParameter("quantitysell"):"0";
		String pricebuystr=request.getParameter("pricebuy") != null?request.getParameter("pricebuy"):"0";
		String pricesellstr=request.getParameter("pricesell") != null?request.getParameter("pricesell"):"0";
		
		
		double price=0;
		double quantity=0;
		String aon=null;
		if(buyorsell.equalsIgnoreCase("buy")) {
			quantity=Double.parseDouble(quantitybuystr);
			if(orderType.equalsIgnoreCase("market")) {
				price=1000;
			}else {
				if(pricebuystr.equals("")) {doGet(request, response);return;}
				price=Double.parseDouble(pricebuystr);
				aon=request.getParameter("aonbuy");
			}
		}else {//sell
			quantity=Double.parseDouble(quantitysellstr);
			if(orderType.equalsIgnoreCase("market")) {
				price=0;
			}else {
				if(pricebuystr.equals("")) {doGet(request, response);return;}
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
			System.out.println("issue coming here.");
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		boolean allornone=true;
		if(aon==null) {
			allornone=false;
		}
		
		Order order=new Order(buyorsell.toUpperCase(), orderType.toUpperCase(), new Date(), quantity, price, userid, "PENDING", allornone);
//		OrderProcessesInterfaceImpl impl=new OrderProcessesInterfaceImpl();
//		int resu=impl.PlaceOrder(order);
		staticOrdersCl.addToList(order);
//		System.out.println("got post order req");
		System.out.println("Manual order servlet ends.\n");
		response.sendRedirect("test");
	}

}
