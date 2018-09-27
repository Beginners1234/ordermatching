package businessLogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("./register.jsp");
        dispatcher.forward(request, response);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("got post");
		
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		String contact=request.getParameter("contact");
		String balance=request.getParameter("balance");
		String agreeterms=request.getParameter("agreeterms");
		System.out.println(agreeterms);
		String messageOnJsp="Invalid Input";
		
		if(agreeterms == null)
		{	//not agreed to terms
			messageOnJsp="Please Agree to Terms";
		}else if(!password.equals(repassword)){
			messageOnJsp="Passwords dont match";
		}else {
			//registration sucessful
		}
		ValidationImpl validation=new ValidationImpl();
		int res=validation.ValidateUser(fullname);
		if(res==1);//go ahead
		else if(res==0)//already exists
		
		
		
		request.setAttribute("errorString", messageOnJsp);
		request.getRequestDispatcher("register.jsp").forward(request, response);
		//PrintWriter out = response.getWriter();
	    // out.println("<h1>" + fullname+email+password+contact+balance+agreeterms+ "</h1>");
	}

}
