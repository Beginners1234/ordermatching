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

import DAO.TradeTableImpl;
import DAO.UserTableImpl;
import pojo.Trade;
import pojo.User;

/**
 * Servlet implementation class AdminTradeServlet
 */
@WebServlet("/ats")
public class AdminTradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		TradeTableImpl t=new TradeTableImpl();
		List<Trade>list_trades=t.GetAllTrades();
		System.out.println(list_trades);
		String loginId=(String)session.getAttribute("loginId");
		UserTableImpl a=new UserTableImpl();
		List<User>u=a.GetUserByLoginid(loginId);
		User user=u.get(0);
		request.setAttribute("trade_order",list_trades);
		request.setAttribute("name", user.getName());
		RequestDispatcher d1=request.getRequestDispatcher("trade.jsp");
		d1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
