package foodOrder;

import java.util.ArrayList;

public class Order {
	public int orderId;
	public String dishName;
	public int dishCount;
	public static ArrayList <Order> orderList = new ArrayList <>();;
	
	Order (int orderId,String dishName, int dishCount){
		try {
			this.orderId = orderId;
			this.dishName = dishName;
			this.dishCount = dishCount;
			orderList.add(this); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
