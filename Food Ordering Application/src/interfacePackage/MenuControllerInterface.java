package interfacePackage;

import java.util.ArrayList;
import dataPackage.HotelMenuData;

public interface MenuControllerInterface {
	public void addMenu(int hotelId,String dishName, double dishPrice);
	public void showHotelMenu(int hotelId);
	public ArrayList<HotelMenuData> getCurrentHotelMenu(int hotelId);
}
