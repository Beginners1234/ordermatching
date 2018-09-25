package businessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

//import DAO.OrderTableImpl;
//import DAO.TradeTableImpl;
import pojo.Order;
import pojo.Trade;

public class OrderMatching {
	
	public void matchOrder(Order order,List<Order> sellerList,List<Order> buyerList) {
		//OrderTableImpl orderFunctions=new OrderTableImpl();
		String type=order.getOrderCategory();// buy/sell
		
		if(type.equalsIgnoreCase("BUY")) {//current order is to buy
			System.out.println("Order is of type BUY");
			//List<Order> sellerList = orderFunctions.GetOrderForMatching("sell",20.0); //todo
			 
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
				
				Trade trade=new Trade();

				trade.setUserId_buy(order.getUserId());
				trade.setUserId_sell(curSellOrder.getOrderId());
				trade.setOrderId_buy(order.getOrderId());
				trade.setOrderId_sell(curSellOrder.getOrderId());
				trade.setTradedPrice(curSellOrder.getOrderPrice());
				trade.setTradedTime(new Date());
				
				if(order.getRemaining_quantity()<=curSellOrder.getRemaining_quantity()) {
					System.out.println("edge case\n");
					//buy order completed
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
				//OrderTableImpl oimpl=new OrderTableImpl();
				//oimpl.updateOrder(curSellOrder); //todo
				System.out.println("update sell order\n"+curSellOrder+"\n");
				
				//update trade in db
				//TradeTableImpl impl=new TradeTableImpl();
				//impl.AddTrade(trade);
				System.out.println("TRADE: "+trade+"\n");
			}
			
			//update buy order in db
			//if buy is market then mark rejected
			if (order.getOrderType().equalsIgnoreCase("market")) {
				order.setOrderStatus("PARTIAL");
			}
			
			//OrderTableImpl oimpl=new OrderTableImpl();
			//oimpl.updateOrder(order); //todo
			System.out.println("update buy order in db\n"+order+"\n");
			
		}else { //current order is to sell /////////////////////////////////////////////////////////
			System.out.println("Order is of type SELL");
			
			//List<Order> buyerList = orderFunctions.GetOrderForMatching("buy",20.0); //todo
			 
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
				Trade trade=new Trade();

				trade.setUserId_buy(curBuyOrder.getUserId());
				trade.setUserId_sell(order.getOrderId());
				trade.setOrderId_buy(curBuyOrder.getOrderId());
				trade.setOrderId_sell(order.getOrderId());
				trade.setTradedPrice(curBuyOrder.getOrderPrice());
				trade.setTradedTime(new Date());
				
				if(order.getRemaining_quantity()<=curBuyOrder.getRemaining_quantity()) {
					System.out.println("edge case\n");
					//sell order completed
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
				//OrderTableImpl oimpl=new OrderTableImpl();
				//oimpl.updateOrder(curBuyOrder); //todo
				System.out.println("update Buy order\n"+curBuyOrder+"\n");
				
				//update trade in db
				//TradeTableImpl impl=new TradeTableImpl();
				//impl.AddTrade(trade);
				System.out.println("TRADE: "+trade+"\n");
			}
			//update sell order in db
			//if order is market
			if (order.getOrderType().equalsIgnoreCase("market")) {
				order.setOrderStatus("PARTIAL");
			}
			//OrderTableImpl oimpl=new OrderTableImpl();
			//oimpl.updateOrder(order); //todo
			System.out.println("update sell order in db\n"+order+"\n");
		}
		
	}
	
	
	

}
