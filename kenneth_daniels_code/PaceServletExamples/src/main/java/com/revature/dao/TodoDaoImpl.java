package com.revature.dao;

import java.util.List;

import com.revature.data.DataSource;
import com.revature.exception.TodoNotFoundException;
import com.revature.model.Todo;

public class TodoDaoImpl implements TodoDao {
	
	private final DataSource dataSource = DataSource.getInstance();

	@Override
	public List<Todo> getAllTodos() {
		return dataSource.getTodoTable();
	}

	@Override
	public Todo getTodoById(int id) {
		return dataSource.getTodoTable().stream()
				.filter(todo -> todo.getId() ==id)
				.findFirst().orElseThrow(() -> new TodoNotFoundException(id));
	}

	@Override
	public Todo createTodo(Todo todo) {
		if (dataSource.getTodoTable().add(todo)) {
			return todo;
		}
		return null;
	}

	@Override
	public Todo updateTodo(Todo todo) {
		//create the update value
		Todo updated = getTodoById(todo.getId());
		
		//update for todo's state
		updated.setBody(todo.getBody());
		updated.setTitle(todo.getTitle());
		
		//store the updated value
		for (int i = 0; i < dataSource.getTodoTable().size(); i++) {
			if (dataSource.getTodoTable().get(i).getId() == todo.getId())
				dataSource.getTodoTable().set(i, updated);
			return updated;
		}
		return null;
	}

	@Override
	public Todo deleteTodo(int id) {
		//reference the existing id
		Todo toBeRemoved = getTodoById(id);
		
		//for every todo in our table, remove if the todo's id equals the parameter
		dataSource.getTodoTable().removeIf(anything -> anything.getId() == id);
		return toBeRemoved;		
	}

}
