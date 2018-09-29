package businessLogic;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import DAO.OrderTableImpl;
import DAO.TradeTableImpl;
//import DAO.OrderTableImpl;
//import DAO.TradeTableImpl;
import pojo.Order;
import pojo.Trade;

public class OrderMatching {
	OrderTableImpl oimpl=new OrderTableImpl();
	TradeTableImpl timpl=new TradeTableImpl();
	Trade trade=new Trade();
	public void matchOrder(Order order) {
		//OrderTableImpl orderFunctions=new OrderTableImpl();
		String type=order.getOrderCategory();// buy/sell
		
		if(type.equalsIgnoreCase("BUY")) {//current order is to buy
			System.out.println("Order is of type BUY\n");
			
			List<Order> sellerList = oimpl.GetOrderForMatching("sell",20);
			ListIterator<Order> litr = sellerList.listIterator();
			
			while(order.getRemaining_quantity()>0) {
				if(litr.hasNext()==false)break;
				Order curSellOrder=litr.next();
				//double curSellQuantity=curSellOrder.getRemaining_quantity();
				
				if(order.getOrderPrice()<curSellOrder.getOrderPrice()) {
					//cant be executed
					System.out.println("order cant be executed due to price diff");
					break;
				}
				
				if(order.isAon()) {
				 //if curSellOrder has rem_qty<order.qty then continue
					if(curSellOrder.getRemaining_quantity()<order.getRemaining_quantity()) {
						continue; //go to next sell order
					}
				}
				
				trade=new Trade();

				trade.setUserId_buy(order.getUserId());
				trade.setUserId_sell(curSellOrder.getOrderId());
				trade.setOrderId_buy(order.getOrderId());
				trade.setOrderId_sell(curSellOrder.getOrderId());
				//trade.setTradedPrice(order.getOrderPrice());
				trade.setTradedPrice(curSellOrder.getOrderPrice());
				trade.setTradedTime(new Date());
				
				if(order.getRemaining_quantity()<=curSellOrder.getRemaining_quantity()) {
					System.out.println("edge case\n");
					//buy order completed
					if(curSellOrder.isAon()&&(order.getRemaining_quantity()!=curSellOrder.getRemaining_quantity())) {
						System.out.println("not using current sell order due to aon");
						continue; //go to next sell order as this one is aon
					}
					trade.setTradedQuantity(order.getRemaining_quantity());
					order.setOrderStatus("COMPLETED");
					curSellOrder.setRemaining_quantity(curSellOrder.getRemaining_quantity()-order.getRemaining_quantity());
					if(curSellOrder.getRemaining_quantity()==0.0)curSellOrder.setOrderStatus("COMPLETED");
					order.setRemaining_quantity(0);
					
				}else { //quantityToBuy<curSellQuantity
					trade.setTradedQuantity(curSellOrder.getRemaining_quantity());
					order.setRemaining_quantity(order.getRemaining_quantity()-curSellOrder.getRemaining_quantity());
					//sell curSellOrder completely
					curSellOrder.setRemaining_quantity(0);
					curSellOrder.setOrderStatus("COMPLETED");
					
				}
				
				//update sell orders in db
				
				oimpl.UpdateOrderByOrderId(curSellOrder); //todo
				System.out.println("updated sell order\n"+curSellOrder+"\n");
				
				//update trade in db
				
				timpl.AddTrade(trade);
				System.out.println("TRADE: "+trade+"\n"+"----------------------------------------\n");
				(new SMSsender()).sendSMStoUsers(order, trade);
			}
			
			//update buy order in db
			//if buy is market then mark rejected
			if (order.getOrderType().equalsIgnoreCase("market")) {
				if(order.getRemaining_quantity()!=order.getOrderQuantity())
					order.setOrderStatus("COMPLETED");
				else
					order.setOrderStatus("REJECTED");
			}
			
			oimpl.UpdateOrderByOrderId(order); //todo
			System.out.println("update buy order in db after trade\n"+order+"\n");
			
			(new SMSsender()).sendSMStoUsers(order, trade);
			
		}else { //current order is to sell /////////////////////////////////////////////////////////
			System.out.println("Order is of type SELL\n");
			
			List<Order> buyerList = oimpl.GetOrderForMatching("buy",20); //todo
			 
			ListIterator<Order> litr = buyerList.listIterator();
			
			while(order.getRemaining_quantity()>0) {
				if(litr.hasNext()==false)break;
				Order curBuyOrder=litr.next();
				
				if(order.getOrderPrice()>curBuyOrder.getOrderPrice()) {
					//cant be executed
					System.out.println("order cant be executed due to price diff");
					break;
				}
				
				if(order.isAon()) {
					 //if curBuyOrder has rem_qty<order.qty then go to next
						if(curBuyOrder.getRemaining_quantity()<order.getRemaining_quantity()) {
							continue; //go to next buy order
						}
					}
				trade=new Trade();

				trade.setUserId_buy(curBuyOrder.getUserId());
				trade.setUserId_sell(order.getOrderId());
				trade.setOrderId_buy(curBuyOrder.getOrderId());
				trade.setOrderId_sell(order.getOrderId());
				trade.setTradedPrice(curBuyOrder.getOrderPrice());
				//trade.setTradedPrice(order.getOrderPrice());
				trade.setTradedTime(new Date());
				
				if(order.getRemaining_quantity()<=curBuyOrder.getRemaining_quantity()) {
					System.out.println("edge case\n");
					//sell order completed
					if(curBuyOrder.isAon()&&(order.getRemaining_quantity()!=curBuyOrder.getRemaining_quantity())) {
						System.out.println("not using current buy order due to aon");
						continue; //go to next buy order as this one is aon
					}
					trade.setTradedQuantity(order.getRemaining_quantity());
					
					order.setOrderStatus("COMPLETED");
					curBuyOrder.setRemaining_quantity(curBuyOrder.getRemaining_quantity()-order.getRemaining_quantity());
					if(curBuyOrder.getRemaining_quantity()==0.0)curBuyOrder.setOrderStatus("COMPLETED");
					order.setRemaining_quantity(0);
				}else { //quantityToSell<curbuyQuantity
					//buy order completed
					trade.setTradedQuantity(curBuyOrder.getRemaining_quantity());
					order.setRemaining_quantity(order.getRemaining_quantity()-curBuyOrder.getRemaining_quantity());
					curBuyOrder.setRemaining_quantity(0);
					curBuyOrder.setOrderStatus("COMPLETED");
				}
				//update buy orders in db
				
				oimpl.UpdateOrderByOrderId(curBuyOrder); //todo
				System.out.println("updated Buy order\n"+curBuyOrder+"\n");
				
				//update trade in db
				
				timpl.AddTrade(trade);
				System.out.println("TRADE: "+trade+"\n"+"----------------------------------------\n");
			
				(new SMSsender()).sendSMStoUsers(order, trade);
			}
			//update sell order in db
			//if order is market
			if (order.getOrderType().equalsIgnoreCase("market")) {
				if(order.getRemaining_quantity()!=order.getOrderQuantity())
					order.setOrderStatus("COMPLETED");
				else
					order.setOrderStatus("REJECTED");
			}
			
			oimpl.UpdateOrderByOrderId(order);
			System.out.println("update sell order in db after trade\n"+order+"\n");
			
			(new SMSsender()).sendSMStoUsers(order, trade);
		}
		
	}
	
	
	

}
