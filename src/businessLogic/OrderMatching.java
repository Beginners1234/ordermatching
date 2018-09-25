package businessLogic;

import DAO.OrderTableImpl;
import pojo.Order;
import pojo.Trade;

public class OrderMatching {
	
	public int matchOrderFromDB() {
		OrderTableImpl orderFunctions=new OrderTableImpl();
		try {
			
		Order buy =  orderFunctions.getFirstBuyOrder(); //has max price
		Order sell =  orderFunctions.getFirstSellOrder(); //has min price
		
		if(buy.getOrderPrice()<sell.getOrderPrice()) {
			//cant match order as prices are apart
		}else {
			
			Trade trade =new Trade();
			
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}
	

}
