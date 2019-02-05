package com.revature.dao;

import java.util.List;

import com.revature.model.Todo;

public interface TodoDao {

	//read all
	List<Todo> getAllTodos();
	
	//read one
	Todo getTodoById(int id);
	
	//create
	Todo createTodo(Todo todo);
	
	//update
	Todo updateTodo(Todo todo);
	
	//delete
	Todo deleteTodo(int id);
}
