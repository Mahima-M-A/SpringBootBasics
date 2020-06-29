package com.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	private String todoItem;
	private String status;
	
	public Todo() {}
	
	public Todo(String todoItem, String status) {
		super();
		this.todoItem = todoItem;
		this.status = status;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTodoItem() {
		return todoItem;
	}
	
	public void setTodoItem(String todoItem) {
		this.todoItem = todoItem;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}