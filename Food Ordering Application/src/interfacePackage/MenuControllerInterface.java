package interfacePackage;

import java.util.ArrayList;
import dataPackage.HotelMenuData;

public interface MenuControllerInterface {
	void addMenu(int hotelId,String dishName, double dishPrice);
	void showHotelMenu(int hotelId);
	ArrayList<HotelMenuData> getCurrentHotelMenu(int hotelId);
}
