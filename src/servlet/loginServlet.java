package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");       
 
       
        boolean hasError = false;
        String errorString = null;
 
        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            //check validation function
        	//errorString = "User Name or password invalid";
           
        }
        
        if (hasError) {
            request.setAttribute("errorString", errorString);
            // Forward to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
            dispatcher.forward(request, response);
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("username", userName);
            if(userName.equals("admin"))
            	{	
            		//redirect to admin servlet
                RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
                dispatcher.forward(request, response);	
            	
            	}
            else	
            	{
            		//redirect to user servlet
                RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/loginView.jsp");
                dispatcher.forward(request, response);	
            	}
           
        	}

	}
}


