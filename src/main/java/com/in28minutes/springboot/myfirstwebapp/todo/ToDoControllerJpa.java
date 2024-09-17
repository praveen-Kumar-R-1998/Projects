package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@SessionAttributes(names = "name")
public class ToDoControllerJpa {

	@Autowired
	private ToDoService service;
	
	@Autowired
	private ToDoRepository repository;

	@RequestMapping("/list-todos")
	public String listAllToDOs(ModelMap model) {
		String userName = getLoggedInUserName(model);

		List<ToDo> todos = repository.findByUserName(userName);
		model.addAttribute("todos", todos);
		return "ListToDos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		String userName = getLoggedInUserName(model);
		ToDo todo = new ToDo(0, userName, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addNewToDo(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String userName = getLoggedInUserName(model);
		service.addToDo(userName, todo.getDescription(), todo.getDate(), false);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/delete-todo")
	public String deleteToDo(@RequestParam int id) {
		service.deleteById(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateToDoPage(ModelMap model, @RequestParam int id) {
		ToDo todo = service.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateToDo(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String userName = getLoggedInUserName(model);
		todo.setUserName(userName);
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
