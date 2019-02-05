package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.model.Todo;

public class TodoDaoTest {

	private final TodoDao dao = new TodoDaoImpl();
	
	@Test
	public void test() {
		List<Todo> todos = dao.getAllTodos();
		
		assertEquals(20, todos.size());
		
		for (int i = 1; i < 21; i++) {
			assertEquals(i, todos.get(i).getId());
			assertEquals("Title: " + i, todos.get(i).getTitle());
			assertEquals("Body: " + i, todos.get(i-1).getBody());
		}
	}
	
	@Test
	public void dao_ShouldReturnTodoById() {
		assertTrue(dao.getTodoById(1) instanceof Todo);
		
	}
	
	@Test
	public void dao_ShouldCreateATodo() {
		dao.createTodo(new Todo(21, "Some Title", "Some body"));
		
		assertEquals(21, dao.getAllTodos().size());
	}
}
