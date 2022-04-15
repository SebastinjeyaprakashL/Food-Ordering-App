package foodOrder;

import java.util.ArrayList;
import java.util.HashMap;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class Order {
	public int orderId;
	public String dishName;
	public int dishCount;
	public static ArrayList <Order> orderList = new ArrayList <>();;
	
	Order (int orderId,String dishName, int dishCount){
		this.orderId = orderId;
		this.dishName = dishName;
		this.dishCount = dishCount;
		orderList.add(this); 
	}
	
}
