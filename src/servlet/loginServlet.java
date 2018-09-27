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
import businessLogic.ValidationImpl;
import pojo.Order;
import pojo.Trade;
import pojo.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login2")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("welcome to login2servlet");
		String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");       
 
       
        boolean hasError = false;
        String errorString = null;
 
        if (loginId == null || password == null || password.length() == 0 || loginId.length() == 0)
        {
        	System.out.println("no input error");
            hasError = true;
            errorString = "Required username and password!";
        }
        else 
        {
        	System.out.println("atleast no input error");
        	ValidationImpl v=new ValidationImpl();
        	int res=v.Authenticationcheck(loginId, password);
        	if(res==1) {hasError=false;}
        	else if(res==2) {hasError=true;errorString="User does not exist";}
        	else if(res==0) {hasError=true;errorString="Wrong password";}
        	
        }
        
        if (hasError) 
        {
            request.setAttribute("errorString", errorString);
            System.out.println(errorString);
            // Forward to /WEB-INF/views/login.jsp
            //System.out.println("");
            RequestDispatcher dispatcher= request.getRequestDispatcher("./login.jsp");
            dispatcher.forward(request, response);
            
        }
        else {
        	System.out.println("success user found");
            HttpSession session = request.getSession();
            session.setAttribute("loginId", loginId);
            request.setAttribute("loginId", loginId);
            if(loginId.equals("admin"))
            	{
            	response.sendRedirect("admin");
            	return;
            	
            	}
            else	
            	{
            	  System.out.println("user servlet accessed");
          		UserTableImpl a=new UserTableImpl();
          		OrderProcessesInterfaceImpl b=new OrderProcessesInterfaceImpl();
          		OrderTableImpl i=new OrderTableImpl();
          		TradeTableImpl t=new TradeTableImpl();
          		//HttpSession session2=request.getSession();
          		//Boolean check=session2.getAttribute("loginId").equals(null);
//          		if(check==false)
//          		{
//          			RequestDispatcher d=request.getRequestDispatcher("/pages/examples/login.jsp");
//          			d.forward(request, response); 
//          		}

          		
          		//String loginId2=(String)session.getAttribute("loginId");		
          		List<User>u=a.GetUserByLoginid(loginId);
          		User user=u.get(0);
          		int number_orders=b.GetStatisticsUser(user.getUserId(),"order");
          		int number_trades=b.GetStatisticsUser(user.getUserId(),"trade");
          		int number_position=b.GetStatisticsUser(user.getUserId(), "positon");
          		request.setAttribute("statistics_order", number_orders);
          		request.setAttribute("statistics_trade", number_trades);
          		request.setAttribute("statistics_position", number_position);
          		request.setAttribute("name", user.getName());
          		int n=5;
          		List<Order>list_orders=i.GetOrderByUserId(user.getUserId(),n);
          		List<Trade>list_trades=t.GetTradesByUserId(user.getUserId(),n);
          	    request.setAttribute("list_orders",list_orders);
          		request.setAttribute("list_trades",list_trades);
          		RequestDispatcher d=request.getRequestDispatcher("index2_user.jsp");
          		d.forward(request, response);
            	}
           
        	}

	}
}


