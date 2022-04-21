package interfacePackage;

import java.util.ArrayList;

import dataPackage.HotelData;

public interface HotelControllerInterface {
	void addHotel (int hotelId, String hotelName);
	ArrayList<HotelData> getHotels ();
	HotelData chooseHotelToOrder () ;
}
