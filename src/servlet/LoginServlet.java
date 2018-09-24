package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	//this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
    	res.sendRedirect("/ProjTest");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request got");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String user=req.getParameter("username");
		String pass=req.getParameter("userpass");
		String message = "Wrong Info";
		
		if (user.equals("admin") && pass.equals("admin"))
			this.getServletContext().getRequestDispatcher("/views/adminhome.jsp").forward(req, response);
		else if(user.equals("user")) {

			req.setAttribute(user, "asdjalsdjalk");
			req.getRequestDispatcher("/views/userhome.jsp").forward(req, response);
		}
		else
		{
			req.setAttribute("message", message);
			req.getRequestDispatcher("/index.jsp").forward(req, response);
		}
		pw.close();
		
	}

}
