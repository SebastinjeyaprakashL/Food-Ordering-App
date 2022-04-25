package databasePackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import inputOutputPackage.Output;

public class DatabaseHelper {
	private Statement statement = null;
	
	public void createDbIfNotExists (Connection dbConnection) {
		try {
			String query = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'Console Application'";
			statement = dbConnection.createStatement();
			ResultSet database = statement.executeQuery(query);
			if (database.next()) {
				return;
			}
			else {
				String createDbQuery = "CREATE DATABASE 'Console Application'";
				statement.execute(createDbQuery);
				createTables (dbConnection);
			}
		}
		catch (SQLException e) {
			Output.printInConsole("Error in fetching database !" + e);
		}
	}
	
	private void createTables (Connection dbConnection) {
		try {
			ArrayList <String> tableCreationList = getTableCreationList();
			statement = dbConnection.createStatement();
			for (String tableCreateQuery : tableCreationList) {
				statement.execute(tableCreateQuery);
			}
		}
		catch (SQLException e) {
			Output.printInConsole("Error occurred while verifying tables in database");
		}
	}
	
	private ArrayList <String> getTableCreationList (){
		try {
			ArrayList <String> tableCreationList = new ArrayList<>();
			String userTableCreateQuery = "CREATE TABLE IF NOT EXISTS `food_order_application_users` (\r\n"
					+ "  `userId` int unsigned NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,\r\n"
					+ "  `email` varchar(255) NOT NULL,\r\n"
					+ "  `mobile` varchar(10) DEFAULT NULL,\r\n"
					+ "  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,\r\n"
					+ "  PRIMARY KEY (`userId`)\r\n"
					+ ")";
			tableCreationList.add(userTableCreateQuery);
			
			String hotelTableCreateQuery = "CREATE TABLE IF NOT EXISTS `food_order_application_hotels` (\r\n"
					+ "  `hotelId` int unsigned NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `name` varchar(60) NOT NULL,\r\n"
					+ "  PRIMARY KEY (`hotelId`)\r\n"
					+ ")";
			tableCreationList.add(hotelTableCreateQuery);
			
			String menuTableCreateQuery = "CREATE TABLE IF NOT EXISTS `food_order_application_hotel_menu` (\r\n"
					+ "  `menuId` int unsigned NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `hotelId` int unsigned NOT NULL,\r\n"
					+ "  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,\r\n"
					+ "  `price` double unsigned NOT NULL,\r\n"
					+ "  PRIMARY KEY (`menuId`) USING BTREE\r\n"
					+ ")";
			tableCreationList.add(menuTableCreateQuery);
			
			String orderTableCreateQuery = "CREATE TABLE IF NOT EXISTS `food_order_application_orders` (\r\n"
					+ "  `orderId` int unsigned NOT NULL,\r\n"
					+ "  `hotelId` int unsigned NOT NULL,\r\n"
					+ "  `userId` int unsigned NOT NULL,\r\n"
					+ "  `dishName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,\r\n"
					+ "  `quantity` int unsigned NOT NULL\r\n"
					+ ")";
			tableCreationList.add(orderTableCreateQuery);
			
			String orderSequenceTableCreateQuery = "CREATE TABLE IF NOT EXISTS `food_order_application_order_sequence` (\r\n"
					+ "  `newOrderNumber` int unsigned NOT NULL DEFAULT '0'\r\n"
					+ ")";
			tableCreationList.add(orderSequenceTableCreateQuery);
			
			return tableCreationList;
		}
		catch (Exception e) {
			Output.printInConsole("Error occurred in fetching table creation list " + e);
		}
		return null;
		
	}
}
