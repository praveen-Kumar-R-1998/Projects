package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jayway.jsonpath.Predicate;

import jakarta.validation.Valid;

@Service
public class ToDoService {

	private static List<ToDo> toDos = new ArrayList<>();
	private static int todosCount = 0;

	static {
		toDos.add(new ToDo(++todosCount, "in28Minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
		toDos.add(new ToDo(++todosCount, "in28Minutes", "Learn Azure", LocalDate.now().plusYears(1), false));
		toDos.add(new ToDo(++todosCount, "in28Minutes", "Learn GC", LocalDate.now().plusYears(1), false));
	}

	public List<ToDo> findByUserName(String Name) {
		java.util.function.Predicate<? super ToDo> predicate = todo -> todo.getUserName().equalsIgnoreCase(Name);
		return toDos.stream().filter(predicate).toList();
	}

	public void addToDo(String userName, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++todosCount, userName, description, targetDate, done);
		toDos.add(todo);
	}

	public void deleteById(int id) {

		java.util.function.Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		toDos.removeIf(predicate);

	}

	public void updateById(int id) {

		java.util.function.Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		toDos.removeIf(predicate);

	}

	public ToDo findById(int id) {
		java.util.function.Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo toDo = toDos.stream().filter(predicate).findFirst().get();
		System.out.println("finding a to do is: " + toDo);
		return toDo;
	}

	public void updateTodo(@Valid ToDo updatedToDo) {
		ToDo existingToDo = findById(updatedToDo.getId());
		if (existingToDo != null) {
			existingToDo.setDescription(updatedToDo.getDescription());
			existingToDo.setDate(updatedToDo.getDate());
			existingToDo.setDone(updatedToDo.isDone());
		}
//        toDos.add(existingToDo);
	}
}
