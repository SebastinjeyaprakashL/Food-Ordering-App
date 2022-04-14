package foodOrder;

import java.util.ArrayList;
import java.util.HashMap;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class Order {
	public static int orderId = 0;
	public int currentOrderId;
	public String dishName;
	public int dishCount;
	public HashMap <String , Integer> orderList ;
	
	Order (){
		Order.orderId = orderId ++;
		orderList = new HashMap<String, Integer>();		
	}

	
	
	
}
