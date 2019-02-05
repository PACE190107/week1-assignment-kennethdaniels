package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.revature.models.Customer;
import com.revature.utils.JDBCConnectionUtil;

//Dao class implements DAO interface
//DAO class inserts/retrieves data from database
//In our example connection to database will be handled by utils

public class CustomerDaoImplementation implements CustomerDao {

	private static CustomerDaoImplementation custDao;
	final static Logger log = Logger.getLogger(CustomerDaoImplementation.class);
	private CustomerDaoImplementation() {
	}
	
	public static CustomerDaoImplementation getCustDao() {
		if (custDao == null) {
			custDao = new CustomerDaoImplementation();
		}
		return custDao;
	}
	
	@Override
	public boolean insertCustomer(Customer cust) {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			String sql = "insert into Customer values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cust.getId());
			ps.setString(2, cust.getFirstName());
			ps.setString(3, cust.getLastName());
			ps.setString(4, cust.getUserName());
			ps.setString(5, cust.getPassword());
			if(ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			Log.error("error occurred in catch block of insert customer dao implementation method");
		}
		return false;
	}

	@Override
	public boolean insertCustomerProcedure(Customer cust) {
		return false;
	}

	@Override
	public Customer getCustomer() {
		
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			log.info("creating statement object");
			Statement stmt = conn.createStatement();
			String sql = "select * from employee_1901";
			
			log.info("executing the query");
			ResultSet results = stmt.executeQuery(sql);
			log.info("viewing the results");
			List<Customer> allCustomers = new ArrayList<>();
			while (results.next()) {
				allCustomers.add(new Customer(
						results.getInt("C_ID"), 
						results.getString("C_firstname"), 
						results.getString("c_lastname"),
						results.getString("C_username"),
						results.getString("C_password")));
			}
			return allCustomers;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new ArrayList<>();
	}

}