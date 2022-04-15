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

}
