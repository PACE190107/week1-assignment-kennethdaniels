package com.revature.frontcontroller;

import com.revature.dao.EmployeeDaoImp;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImp;

public class Dispatcher {

	private Dispatcher() {}
	
	private static final EmployeeService employeeService = new EmployeeServiceImp();
}
