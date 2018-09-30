package test_servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogic.RandomOrderGenerator;
import pojo.Order;



/**
 * Servlet implementation class generateOrderServlet
 */
@WebServlet("/grow")
public class generateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("number").toString().isEmpty())
		{
			response.sendRedirect("test");
			return;
		}
		int number=Integer.parseInt(request.getParameter("number"));
		
//		if(number==0)
//		{
//			response.sendRedirect("test");
//		}
//		System.out.println("here1");
		RandomOrderGenerator r=new RandomOrderGenerator();		
//		System.out.println("here2");
		List<Order> l=r.GeneraterandomOrderFinite(number);
		for (Order order : l) {
			staticOrdersCl.addToList(order);
			System.out.println("Order is"+ order);
		}
//		System.out.println(l);
		
		response.sendRedirect("test");
	}

}
