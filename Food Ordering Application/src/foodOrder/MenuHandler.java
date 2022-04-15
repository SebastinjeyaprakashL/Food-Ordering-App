package foodOrder;

import java.util.ArrayList;

import consoleInputOutput.UserOutput;

public class MenuHandler {
	public int hotelId ;
	public static ArrayList <HotelMenu> hotelMenu = new ArrayList<HotelMenu>();
	public ArrayList <HotelMenu> currentHotelmenuList;
	
	
	public void addMenu(int hotelId,String dishName, double dishPrice) {
		HotelMenu menu = new HotelMenu(hotelId,dishName,dishPrice);
		hotelMenu.add(menu);
	}
	
	public void showHotelMenu(int hotelId) {
		
		currentHotelmenuList = getCurrentHotelMenu(hotelId);
		UserOutput.consoleStringPrinter("\t\t-----------Menu-----------");
		for(HotelMenu menu : currentHotelmenuList) {
			UserOutput.consoleStringPrinter("\t\t"+menu.dishName + " - " + menu.dishPrice);
		}
		UserOutput.consoleStringPrinter("\t\t-----------END-----------");
	}
	
	public ArrayList<HotelMenu> getCurrentHotelMenu(int hotelId){
		ArrayList <HotelMenu> menuList = new ArrayList <HotelMenu>();
		for (HotelMenu menu : HotelMenu.menuList) {
			if(menu.hotelId == hotelId) {
				menuList.add(menu);
			}
		}
		return menuList;
	}

}
