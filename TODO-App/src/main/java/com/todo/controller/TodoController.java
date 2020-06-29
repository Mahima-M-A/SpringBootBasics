package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.model.Todo;
import com.todo.repository.TodoRepository;

@Controller
public class TodoController {

	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/todoList")
	public String todoList(Model model) {
		model.addAttribute("todoList", todoRepository.findAll());
		return "todoList";
	}
	
	@PostMapping("/todoNew")
	public String add(@RequestParam String todoItem, @RequestParam String status, Model model) {
		Todo todo = new Todo(todoItem, status);
		todoRepository.save(todo);
		model.addAttribute("todoList", todoRepository.findAll());
		return "redirect:/todoList";
	}
	
	@PostMapping("/todoDelete/{id}")
	public String delete(@PathVariable long id, Model model) {
		todoRepository.deleteById(id);
		model.addAttribute("todoList", todoRepository.findAll());
		return "redirect:/todoList";
	}
	
	@PostMapping("/todoUpdate/{id}")
	public String update(@PathVariable long id, Model model) {
		Todo todo = todoRepository.findById(id).get();
		if("Yes".equals(todo.getStatus())) {
			todo.setStatus("No");
		}
		else {
			todo.setStatus("Yes");
		}
		todoRepository.save(todo);
		model.addAttribute("todoList", todoRepository.findAll());
		return "redirect:/todoList";
	}
}