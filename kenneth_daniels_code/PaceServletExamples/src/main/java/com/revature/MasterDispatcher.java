package com.revature;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.TodoService;
import com.revature.service.TodoServiceImpl;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	private static final TodoService todoService = new TodoServiceImpl();
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		if (request.getRequestURI().contains("todos"))
				return todoService.process(request, response);
				else
					return "Not yet implemented";
	}
}
