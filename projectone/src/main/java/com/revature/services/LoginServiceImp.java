package com.revature.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.models.Employee;
import com.revature.utils.JDBCConnectionUtil;

public class LoginServiceImp implements LoginService{

	
	@Override
	public Employee attemptAuthentication(String username, String passw0rd) {
		ResultSet rs = null;
		Employee employee = null;	
		System.out.println(username);
		try (Connection conn = JDBCConnectionUtil.getConnection()) {
			//CallableStatement cs = conn.prepareCall("{? = call GET_PASSWORD_HASH(?,?)}");
			String sql = "select * from employee_table WHERE username = ? AND passwrd = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.println(username);
				System.out.println(passw0rd);
				//cs.registerOutParameter(1, Types.VARCHAR);
			//	cs.setString(2, username);
				//cs.setString(3, passw0rd);
			//	cs.execute();
				//passw0rd = cs.getString(1);
				ps.setString(1, username);
				ps.setString(2, passw0rd);
				rs = ps.executeQuery();
				if(rs.next()) {
					employee = new Employee();
					employee.setUser_id(rs.getInt("user_id"));
					employee.setFirstName(rs.getString("firstname"));
					employee.setLastName(rs.getString("lastname"));
					employee.setUserName(rs.getString("username"));
					employee.setPassword(rs.getString("passwrd"));
					employee.setEmailAddress(rs.getString("email"));
					employee.setIsManager(rs.getInt("ismanager"));
				}
		} catch (SQLException e) {
			System.out.println("Here?");
			e.printStackTrace();
		} 
		return employee;
	}
	

}
