package com.todo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Todo;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long> { }