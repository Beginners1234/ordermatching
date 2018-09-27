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
            RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            
        }
        else {
        		if(loginId.equals("admin"))
        		{
        			System.out.println("admin is found");
            		HttpSession session = request.getSession(true);
            		session.setAttribute("loginId", loginId);
            		response.sendRedirect("admin");
        			
        		}
        		else {
        		System.out.println("success user found");
        		HttpSession session = request.getSession(true);
        		session.setAttribute("loginId", loginId);
        		response.sendRedirect("user");}

            }
           

	}
}


