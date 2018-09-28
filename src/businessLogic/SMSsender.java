package businessLogic;

import java.net.HttpURLConnection;
import java.net.URL;

import pojo.Order;
import pojo.Trade;
import pojo.User;


public class SMSsender {
	 public void sendsms(Order o,User u,Trade t) {
         try {
                 String recipient = "8826623010";
                 String message = "Hey There!!!";
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

         } catch(Exception ex) {
                 System.out.println(ex.getMessage());

         }
 }
}
