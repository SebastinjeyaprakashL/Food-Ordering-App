package databasePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import inputOutputPackage.Output;
import dataPackage.HotelData;
import dataPackage.HotelMenuData;
import dataPackage.OrderData;
import dataPackage.UserAccountData;

public class DatabaseHandler {
	private final Connection dbConnection = DbConnect.getConnection();
	private PreparedStatement preparedStatement = null;
	private Statement statement = null;

	private static final DatabaseHandler db = new DatabaseHandler();
	
	private DatabaseHandler() {
		DatabaseHelper dbInitializer = new DatabaseHelper();
		dbInitializer.createDbIfNotExists(dbConnection);
	}

	public static DatabaseHandler getInstance() {
		return db;
	}

	public UserAccountData getUser(String email, String password) {
		try {
			UserAccountData currentUser = new UserAccountData();
			String query = "SELECT * "
					+ "FROM food_order_application_users AS a "
					+ "WHERE a.email = '" + email +"' and a.password = '" + password +"'";
			statement = dbConnection.createStatement();
			ResultSet userData = statement.executeQuery(query);
			if(userData.next()) {
				currentUser.setUserId(userData.getInt("UserId"));
				currentUser.setName(userData.getString("name"));
				currentUser.setEmail(userData.getString("email"));
				currentUser.setMobileNum(userData.getString("mobile"));
				currentUser.setPassword(userData.getString("password"));
				return currentUser;
			}		
		}
		catch (SQLException e) {
			Output.printInConsole("Couldn't fetch user data from database ! Please contact administrator" + e);
		}
		return null;
	}

	public void addUserAccount(UserAccountData newUser) {
		try {
			String 	query = "INSERT INTO food_order_application_users ( name , email , mobile , password ) VALUES ( ? , ? , ? , ? )";
			preparedStatement = dbConnection.prepareStatement(query);
			
			preparedStatement.setString(1, newUser.getName());
			preparedStatement.setString(2, newUser.getEmail());
			preparedStatement.setString(3, newUser.getMobileNum());
			preparedStatement.setString(4, newUser.getPassword());
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				Output.printInConsole("User added!");
			}
		}
		catch (SQLException e) {
			Output.printInConsole("Something went wrong, while connecting database! "+ e);
		}
		finally {
			preparedStatement = null;
		}
	}

	public void addOrderList(ArrayList <OrderData> orderList, UserAccountData currentUser, HotelData currentHotel) {
		boolean isOrderPlacedFlag = false;
		try {
			int newOrderId = getNewOrderId();
			for (OrderData order : orderList) {
				String query = "INSERT INTO food_order_application_orders ( orderId , hotelId , userId , dishName , quantity ) VALUES ( ? , ? , ? , ? , ?)";
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.setInt(1, newOrderId);
				preparedStatement.setInt(2, currentHotel.hotelId);
				preparedStatement.setInt(3, currentUser.getUserId());
				preparedStatement.setString(4, order.dishName);
				preparedStatement.setInt(5, order.dishCount);
				int row = preparedStatement.executeUpdate();
				if (row > 0) {
					preparedStatement = null;
					isOrderPlacedFlag = true;
				}
				else {
					isOrderPlacedFlag = false;
					Output.printInConsole("Unable to place order!");
					break;
				}		
			}
			if (isOrderPlacedFlag) {
				updateOrderSeq(newOrderId+1);
			}
		}
		catch (SQLException e) {
			Output.printInConsole("Error occurred while placing new Order! " + e);
		}
	}

	public ArrayList <HotelData> getHotels() {
		try {
			ArrayList <HotelData> hotelList = new ArrayList<>();
			
			String query = "SELECT * FROM food_order_application_hotels";
			statement = dbConnection.createStatement();
			ResultSet hotelData = statement.executeQuery(query);
			while (hotelData.next()) {
				HotelData hotel = new HotelData();
				hotel.hotelId = hotelData.getInt("hotelId");
				hotel.hotelName = hotelData.getString("name");
				hotelList.add(hotel);
			}
			return hotelList;	
		}
		catch (SQLException e) {
			Output.printInConsole("Couldn't fetch hotel list from database !" + e);
		}
		return null;
	}

	public void addHotel(HotelData newHotel) {
		try {
			String query = "INSERT INTO food_order_application_hotels ( name ) VALUES ( ? )";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, newHotel.hotelName);
			int row = preparedStatement.executeUpdate();
			if (row > 0) {
				Output.printInConsole("Hotel added!");
			}
			else {
				Output.printInConsole("Error occurred while adding new hotel! ");
			}
		}
		catch (SQLException e) {
			Output.printInConsole("Something went wrong, while connecting database! "+ e);
		}
		finally {
			preparedStatement = null;
		}
	}

	public ArrayList <HotelMenuData> getMenuList(int hotelId) {
		try {
			ArrayList <HotelMenuData> menuList = new ArrayList<>();
			String query = "SELECT * FROM food_order_application_hotel_menu as menu WHERE menu.hotelId = " + hotelId ;
			statement = dbConnection.createStatement();
			ResultSet menuData = statement.executeQuery(query);
			while (menuData.next()) {
				HotelMenuData menu = new HotelMenuData();
				menu.dishName = menuData.getString("name");
				menu.dishPrice = menuData.getDouble("price");
				menuList.add(menu);
			}
			return menuList;	
		}
		catch (SQLException e) {
			Output.printInConsole("Couldn't fetch menu list for the selected hotel" + e);
		}
		return null;
	}

	public void addHotelMenu(HotelMenuData menu) {
		try {
			String query = "INSERT INTO food_order_application_hotel_menu ( hotelId , name , price ) VALUES ( ? , ? , ? )";
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, menu.hotelId);
			preparedStatement.setString(2, menu.dishName);
			preparedStatement.setDouble(3, menu.dishPrice);
			int row = preparedStatement.executeUpdate();
			if( row > 0) {
				Output.printInConsole("Menu added");
			}
			else {
				Output.printInConsole("Error in adding new menu !");
			}
		}
		catch (SQLException e) {
			Output.printInConsole("Something went wrong , while adding new menu" + e);
		}
		finally{
			preparedStatement = null;
		}
	}
	
	private int getNewOrderId() {
		int newOrderId = 1;
		try {
			String query = "SELECT * FROM food_order_application_order_sequence LIMIT 1";
			statement = dbConnection.createStatement();
			ResultSet orderId = statement.executeQuery(query);
			if(orderId.next()) {
				return orderId.getInt("newOrderNumber");
			}
		}
		catch (SQLException e) {
			Output.printInConsole("Unable to get order sequence!" + e);
		}
		return newOrderId;
	}
	
	private void updateOrderSeq(int newOrderId) {
		try {
			String query = "UPDATE food_order_application_order_sequence SET newOrderNumber = " + newOrderId ;
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			Output.printInConsole("Error occurred in updating new order Id sequence" + e);
		}
	}
}
