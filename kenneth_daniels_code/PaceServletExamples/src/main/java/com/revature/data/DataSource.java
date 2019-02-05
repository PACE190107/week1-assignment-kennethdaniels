package com.revature.data;

import java.util.List;
import java.util.ArrayList;

import com.revature.model.Todo;

public class DataSource {
	//used to simulate an RDBMS
	
	private static final DataSource instance = new DataSource();
	private static final List<Todo> Todos = new ArrayList<>();
	//restrict exterior instantiation
	private DataSource() {
		for (int i = 1; i<21; i++)
			Todos.add(new Todo(i, "Title: " + i, "Body: " + i));
	}
	
	public static DataSource getInstance() {
		return instance;
	}
	
	public static List<Todo> getTodoTable(){
		return null;
	}
}
