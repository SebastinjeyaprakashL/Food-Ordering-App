package foodOrder;

import java.util.ArrayList;

import consoleInputOutput.UserOutput;

public class MenuHandler {
	public int hotelId ;
	public ArrayList <HotelMenu> currentHotelmenuList;
	
	
	public void addMenu(int hotelId,String dishName, double dishPrice) {
		try {
			HotelMenu menu = new HotelMenu(hotelId,dishName,dishPrice);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void showHotelMenu(int hotelId) {
		try {
			currentHotelmenuList = getCurrentHotelMenu(hotelId);
			UserOutput.consoleStringPrinter("\t\t-----------Menu-----------");
			for(HotelMenu menu : currentHotelmenuList) {
				UserOutput.consoleStringPrinter("\t\t"+menu.dishName + " - " + menu.dishPrice);
			}
			UserOutput.consoleStringPrinter("\t\t-----------END-----------");
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<HotelMenu> getCurrentHotelMenu(int hotelId){
		try {
			ArrayList <HotelMenu> menuList = new ArrayList <HotelMenu>();
			for (HotelMenu menu : HotelMenu.menuList) {
				if(menu.hotelId == hotelId) {
					menuList.add(menu);
				}
			}
			return menuList;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
