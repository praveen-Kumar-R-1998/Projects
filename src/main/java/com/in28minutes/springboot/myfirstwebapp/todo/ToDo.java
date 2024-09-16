package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class ToDo {

	private int id;
	
	private String userName;
	
	@Size(min = 5, message = "Description should contain minimum 5 character")
	private String description;
	
	private LocalDate date;
	
	private boolean done;
	
	

	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDo(int id, String userName, String description, LocalDate date, boolean done) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.date = date;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", userName=" + userName + ", description=" + description + ", date=" + date
				+ ", done=" + done + "]";
	}

}
