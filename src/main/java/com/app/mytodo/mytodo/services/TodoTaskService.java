package com.app.mytodo.mytodo.services;

import com.app.mytodo.mytodo.models.TodoTask;

import java.util.List;

public interface TodoTaskService {
    List<TodoTask> findAll();

    TodoTask findById(Integer id);

    TodoTask create(TodoTask todo);

    TodoTask update(TodoTask todo);

    void delete(Integer id);
}

