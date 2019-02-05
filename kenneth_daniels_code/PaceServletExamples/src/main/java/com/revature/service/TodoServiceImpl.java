package com.revature.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.exception.TodoNotFoundException;
import com.revature.model.Todo;

public class TodoServiceImpl implements TodoService{

	private final TodoDao dao = new TodoDaoImpl();
	
	@Override
	public Object process(HttpServletRequest request, HttpServletResponse response) {
		//get all logic
		if  (request.getMethod().equals("GET")) {
			String [] path = request.getRequestURI().split("/");
			if (path.length == 4) {
				for (String p : path)
					System.out.println("Context Path Segment: " + p);
				return dao.getAllTodos();
			}
			
			//Get one logic
			if (path.length == 5) {
				try {
					int todoId = Integer.valueOf(path[4]);
					return dao.getTodoById(todoId);
				} catch (NumberFormatException e) {
					return "Cannot convert " + path[4] + " into a number";
				} catch (TodoNotFoundException e) {
					return e.getMessage();
				}
			}
		}
		if (request.getMethod().contentEquals("POST")) {
			//create logic
			if (request.getHeader("Content-Type").contentEquals("application/json")) {
				Todo todo = mapper.readValue(request.getReader(), Todo.class);
				return dao.createTodo(todo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return null;
	}

		
}
