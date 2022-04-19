package dataPackage;

import java.util.ArrayList;

public class HotelMenuData {
	public int hotelId;
	public String dishName;
	public double dishPrice;
	public static ArrayList <HotelMenuData> menuList = new ArrayList<>();

	public HotelMenuData(int hotelId,String name, double price) {
		try {
			this.hotelId = hotelId;
			this.dishName = name;
			this.dishPrice = price;
			menuList.add(this);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
