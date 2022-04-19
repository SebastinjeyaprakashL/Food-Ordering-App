package dataPackage;

import java.util.ArrayList;

public class OrderData {
	public int orderId;
	public String dishName;
	public int dishCount;
	public static ArrayList <OrderData> orderList = new ArrayList <>();;
	
	public OrderData (int orderId,String dishName, int dishCount){
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
