package foodOrder;

public class LoadData {
	LoadData (){
		try {
			new UserAccount("User1","user1@testmail.com",989898989, "testUser1");
			new UserAccount("User2","User2@testmail.com",989898000, "testUser2");
			new UserAccount("User3","User3@testmail.com",989898634, "testUse3");
			new UserAccount("User4","test",989898634, "test");
			
			HotelHandler hotelHandler = new HotelHandler();
			hotelHandler.addHotel(1,"Hotel1");
			hotelHandler.addHotel(2,"Hotel2");
			
			
			MenuHandler menuHandler = new MenuHandler();
			menuHandler.addMenu(1,"Veg biriyani",100);
			menuHandler.addMenu(1,"Fried Rice", 250);
			menuHandler.addMenu(1,"Egg Biriyani", 80);
			menuHandler.addMenu(1,"non-veg meals", 120);
			
			menuHandler.addMenu(2,"Chicken Grill", 180);
			menuHandler.addMenu(2,"Shawarma Roll", 90);
			menuHandler.addMenu(2,"Shawarma Plate", 100);
			menuHandler.addMenu(2,"Egg Atho Fry", 120);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
