package com.app.mytodo.mytodo.services.impl;

import com.app.mytodo.mytodo.config.security.SecurityUtils;
import com.app.mytodo.mytodo.dao.TodoTaskDao;
import com.app.mytodo.mytodo.models.TodoTask;
import com.app.mytodo.mytodo.models.User;
import com.app.mytodo.mytodo.services.TodoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@Service
public class TodoTaskServiceImpl implements TodoTaskService {
    @Autowired
    private TodoTaskDao todoDao;

    @Transactional(readOnly = true)
    @Override
    public List<TodoTask> findAll() {
        User user = SecurityUtils.getAuthenticatedUser();

        if(user == null) {
            return Collections.emptyList();
        }

        return todoDao.findAllByUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public TodoTask findById(Integer id) {
        return todoDao.findById(id).orElseGet((Supplier<? extends TodoTask>) new TodoTask());
    }

    @Transactional
    @Override
    public TodoTask create(TodoTask todo) {
        todo.setUser(SecurityUtils.getAuthenticatedUser());
        todoDao.save(todo);

        return todo;
    }

    @Transactional
    @Override
    public TodoTask update(TodoTask todo) {
        todoDao.save(todo);
        return todo;
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        todoDao.deleteById(id);
    }
}
