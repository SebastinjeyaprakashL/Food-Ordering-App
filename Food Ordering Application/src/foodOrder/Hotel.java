package foodOrder;

import java.util.ArrayList;

public class Hotel {
	public int hotelId;
	public String hotelName;
	public static ArrayList <Hotel> hotels = new ArrayList <Hotel>();
	
	public Hotel(int id, String hotelName) {
		try {
			this.hotelId = id;
			this.hotelName = hotelName;
			hotels.add(this);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
