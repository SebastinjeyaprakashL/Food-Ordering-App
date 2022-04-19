package dataPackage;

import java.util.ArrayList;

public class HotelData {
	public int hotelId;
	public String hotelName;
	public static ArrayList <HotelData> hotels = new ArrayList <HotelData>();
	
	public HotelData(int id, String hotelName) {
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
