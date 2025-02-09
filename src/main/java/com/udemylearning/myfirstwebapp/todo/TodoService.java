package com.udemylearning.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static int todosCount = 0;
	private static List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add(new Todo(++todosCount,"in28minutes"
				,"Learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"in28minutes"
				,"Learn Azure",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount,"in28minutes"
				,"Learn Spring",LocalDate.now().plusYears(3),false));
	}

	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	} 
	
	public void deleteByID(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
//		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//		todos.stream().filter(predicate).findFirst().get();
		
		for(Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	 
	public void updateTodo(Todo todo) {
		for(Todo t : todos) {
			if (todo.getId() == t.getId()) {
				t.setDescription(todo.getDescription());
				t.setTargetDate(todo.getTargetDate());
				break;
			}
		}
	}
}