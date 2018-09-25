package businessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import DAO.OrderTableImpl;
import DAO.TradeTableImpl;
import pojo.Order;
import pojo.Trade;

public class OrderMatching {
	
	public void matchOrder(Order order,List<Order> sellerList) {
		OrderTableImpl orderFunctions=new OrderTableImpl();
		String type=order.getOrderCategory();// buy/sell
		
		if(type.equalsIgnoreCase("BUY")) {//current order is to buy
			System.out.println("Order is of type BUY");
			//List<Order> sellerList = orderFunctions.getTop20orders("sell",20); //todo
			 
			ListIterator<Order> litr = sellerList.listIterator();
			double buyPrice=order.getOrderPrice();
			double quantityToBuy=order.getRemainingQuantity(); //todo
			
			while(quantityToBuy>0) {
				if(litr.hasNext()==false)break;
				Order curSellOrder=litr.next();
				double curSellQuantity=curSellOrder.getRemainingQuantity();
				
				if(buyPrice<curSellOrder.getOrderPrice()) {
					//cant be executed
					System.out.println("order cant be executed due to price diff");
					break;
				}
				Trade trade=new Trade();

				trade.setUserId_buy(order.getUserId());
				trade.setUserId_sell(curSellOrder.getOrderId());
				trade.setOrderId_buy(order.getOrderId());
				trade.setOrderId_sell(curSellOrder.getOrderId());
				trade.setTradedPrice(curSellOrder.getOrderPrice());
				trade.setTradedTime(new Date());
				
				if(quantityToBuy<=curSellQuantity) {
					System.out.println("edge case\n");
					//buy order completed
					trade.setTradedQuantity(quantityToBuy);
					order.setRemainingQuantity(0);
					order.setOrderStatus("COMPLETED");
					curSellOrder.setRemainingQuantity(curSellQuantity-quantityToBuy);
					if(curSellOrder.getRemainingQuantity()==0.0)curSellOrder.setOrderStatus("COMPLETED");
					
					quantityToBuy=0;
					
				}else { //quantityToBuy<curSellQuantity
					trade.setTradedQuantity(curSellQuantity);
					quantityToBuy=quantityToBuy-curSellQuantity;
					//sell curSellOrder completely
					curSellOrder.setRemainingQuantity(0);
					curSellOrder.setOrderStatus("COMPLETED");
					
				}
				
				
				
				//update sell orders in db
				OrderTableImpl oimpl=new OrderTableImpl();
				//oimpl.updateOrder(curSellOrder); //todo
				System.out.println("update sell order\n"+curSellOrder+"\n");
				
				//update trade in db
				TradeTableImpl impl=new TradeTableImpl();
				impl.AddTrade(trade);
				System.out.println("TRADE: "+trade+"\n");
			}
			//update buy order in db
			OrderTableImpl oimpl=new OrderTableImpl();
			order.setRemainingQuantity(quantityToBuy);
			//oimpl.updateOrder(order); //todo
			System.out.println("update buy order\n"+order+"\n");
			
		}else { //current order is to sell
			System.out.println("Order is of type SELL");
			
		}
		
	}
	
	
	

}
