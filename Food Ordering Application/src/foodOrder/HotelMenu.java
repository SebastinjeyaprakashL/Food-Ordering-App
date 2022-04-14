package foodOrder;

import java.util.ArrayList;

public class HotelMenu {
	public int hotelId;
	public String dishName;
	public double dishPrice;
	public static ArrayList <HotelMenu> menuList = new ArrayList <HotelMenu>();;

	public HotelMenu(int hotelId,String name, double price) {
		this.hotelId = hotelId;
		this.dishName = name;
		this.dishPrice = price;
		menuList.add(this);
	}
	
	
//	public void addMenu(Hotel hotel,int i, String string, double j) {
//		this.hotel = hotel;
//		this.dishId = i;
//		this.dishName = string;
//		this.dishPrice = j;
//		menuList.add(this);
//		
//	}
//	
//	public void addMenu(int menuId,String dishName, double price) {
//		this.dishName = dishName;
//		this.dishPrice = price;
//		menuList.add(this);
//		System.out.println(menuList);
//	}

}
