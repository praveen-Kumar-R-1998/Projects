package com.springboot.myfirstwebapp.todoapplication.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

	public List<ToDo> findByUserName(String userName);
}
