package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.ValidationImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
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
		String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");       
 
       
        boolean hasError = false;
        String errorString = null;
 
        if (loginId == null || password == null || password.length() == 0 || loginId.length() == 0)
        {
            hasError = true;
            errorString = "Required username and password!";
        }
        else 
        {
        	ValidationImpl v=new ValidationImpl();
        	int res=v.Authenticationcheck(loginId, password);
        	if(res==1) {hasError=false;}
        	else if(res==2) {hasError=true;errorString="User does not exist";}
        	else if(res==0) {hasError=true;errorString="Wrong password";}
        	
        }
        
        if (hasError) 
        {
            request.setAttribute("errorString", errorString);
            // Forward to /WEB-INF/views/login.jsp
            //System.out.println("");
            RequestDispatcher dispatcher= request.getRequestDispatcher("/pages/examples/login.jsp");
            dispatcher.forward(request, response);
            
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("loginId", loginId);
            request.setAttribute("loginId", loginId);
            if(loginId.equals("admin"))
            	{
            	response.sendRedirect("admin");
            	
            	}
            else	
            	{
            	response.sendRedirect("user");
            	}
           
        	}

	}
}


