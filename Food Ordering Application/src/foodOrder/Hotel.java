package foodOrder;

import java.util.ArrayList;

public class Hotel {
	public int hotelId;
	public String hotelName;
	public static ArrayList <Hotel> hotels = new ArrayList <Hotel>();
	
	public Hotel(int id, String hotelName) {
		this.hotelId = id;
		this.hotelName = hotelName;
		hotels.add(this);
		
	}
	
	

}
