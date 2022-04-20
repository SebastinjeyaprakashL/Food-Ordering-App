package interfacePackage;

import java.util.ArrayList;

import dataPackage.HotelData;

public interface HotelControllerInterface {
	public void addHotel (int hotelId, String hotelName);
	public ArrayList<HotelData> getHotels ();
	public HotelData chooseHotelToOrder () ;
}
