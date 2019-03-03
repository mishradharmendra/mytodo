package com.app.mytodo.mytodo.dao;

import com.app.mytodo.mytodo.models.TodoTask;
import com.app.mytodo.mytodo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoTaskDao extends CrudRepository<TodoTask, Integer> {

    List<TodoTask> findAllByUser(User user);
}
