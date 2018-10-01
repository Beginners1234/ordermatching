package businessLogic;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Date;

import org.junit.Test;

import DAO.UserTableImpl;
import pojo.Order;
import pojo.Trade;
import pojo.User;


public class SMSsender {
	UserTableImpl uimpl=new UserTableImpl();
	@Test
	public void test() {
		Order order1=new Order("buy", "limit", new Date(), 500, 155, 1007, "PENDING", false);
		Order order2=new Order("sell", "market", new Date(), 500, 155, 1007, "PENDING", false);
		Trade trade=new Trade(12, 13, 1007, 1007, 999, 12, new Date());
		sendSMStoUsers(order1,new Trade());
		
	}

	public void sendSMStoUsers(Order order1, Trade trade) {

		String email1 = uimpl.GetEmailByOrderId(order1.getUserId());

		double contact1dou = uimpl.GetContactByOrderId(order1.getUserId());
		String contact1 = Double.toString(contact1dou);
		contact1 = contact1.replace(".", "");
		contact1 = contact1.substring(0, contact1.length() - 2);

		String message1 = "Your " + order1.getOrderCategory() + " " + order1.getOrderType() + " order of Quantity "
				+ order1.getOrderQuantity() + " was executed at " + trade.getTradedPrice() ;

		
		System.out.println(message1);

		if (order1.getOrderStatus().equalsIgnoreCase("COMPLETED")) {
			 sendsms(contact1,message1);
			System.out.println("Sent->"+ contact1+" "+message1);
		}
	
	}
	 private void sendsms(String recipient,String message) {
         try {
                 //String recipient = "8826623010";
        	 	//String recipient = receiver;
        	 	if(recipient.length()==10)
        	 	{
        	 		//String message = "Hey There!!!";
        	 		String username = "admin";
        	 		String password = "admin";
        	 		String originator = "+441234567";
        	 		String authkey = "239524AqSQPKNS2p5bab2609";
        	 		String route = "1";

        	 		String requestUrl = "http://api.msg91.com/api/sendhttp.php?country=91&"
        	 				+ "sender=MSGIND&"
        	 				+ "route=1&"
        	 				+ "mobiles=+91"+recipient+"&"
        	 				+ "authkey="+authkey+"&"
        	 				+ "message=" + message;

        	 		System.out.println("requestURL : " + requestUrl);

        	 		URL url = new URL(requestUrl);
        	 		HttpURLConnection uc = (HttpURLConnection)url.openConnection();

        	 		System.out.println("HttpURLConnection status : " + uc.getResponseMessage());

        	 		uc.disconnect();
        	 	}
         } catch(Exception ex) {
                 System.out.println(ex.getMessage());

         }
 }
}
