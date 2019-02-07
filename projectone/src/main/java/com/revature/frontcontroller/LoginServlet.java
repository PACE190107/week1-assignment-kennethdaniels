package com.revature.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.LoginService;
import com.revature.services.LoginServiceImp;

public class LoginServlet extends HttpServlet{
	private final ObjectMapper mapper = new ObjectMapper();
	private static final long serialVersionUID = 1L;

	private final LoginService service = new LoginServiceImp();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//final String username = req.getParameter("username");
	//	final String passw0rd = req.getParameter("passw0rd");// <input name="passw0rd" >
		resp.setContentType("application/json");
		Employee testEmployee = null;
		testEmployee = mapper.readValue(req.getReader(), Employee.class);
		final String username = testEmployee.getUserName();
		final String passw0rd = testEmployee.getPassword();
		System.out.println("IN the do post");
		
		Employee attempting = service.attemptAuthentication(username, passw0rd);
		System.out.println(attempting.getIsManager());
		if (attempting != null) {
			req.getSession().setAttribute("user_id", attempting.getUser_id());
			req.getRequestDispatcher("manager.html").forward(req, resp);
			
		}
	}
}
