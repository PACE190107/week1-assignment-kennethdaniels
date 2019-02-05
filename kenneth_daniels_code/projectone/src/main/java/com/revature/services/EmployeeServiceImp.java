package com.revature.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.exception.EmployeeNotFoundException;

public class EmployeeServiceImp implements EmployeeService{
	
	private final EmployeeDao dao = new EmployeeDaoImp();
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public Object process(HttpServletRequest req, HttpServletResponse resp) {
		if (req.getMethod().contentEquals("GET")) {
			String[] path = req.getRequestURI().split("/");
			if (path.length == 4) {
				return dao.getAllEmployees();
			}
			
			if (path.length == 5) {
				try {
					int employeeId = Integer.valueOf(path[4]);
					return dao.getEmployee(employeeId);
				} catch (NumberFormatException e) {
					return "Cannot convert " + path[4] + " into a number";
				} catch (EmployeeNotFoundException e) {
					return e.getMessage();
				}
			}
		}
		return null;
	}

}
