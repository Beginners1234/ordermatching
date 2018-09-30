package test_servlets;

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

import DAO.UserTableImpl;
import pojo.Order;
import pojo.User;

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
		
		UserTableImpl a=new UserTableImpl();
		List<User> uas=a.GetUserByLoginid(loginId);
		User user=uas.get(0);
		request.setAttribute("name", user.getName());	
		
		System.out.println("test servlet");
//		Order o=new Order("BUY", "Limit", null, 100, 152, 1, "pending", true);
//		staticOrdersCl.addToList(o);
		List<Order> l=staticOrdersCl.getList();		
	
		request.setAttribute("order", l);
		RequestDispatcher dis=request.getRequestDispatcher("admin_test.jsp");
		dis.forward(request, response);
	}

}
