package com.app.mytodo.mytodo.controllers;

import com.app.mytodo.mytodo.models.TodoTask;
import com.app.mytodo.mytodo.services.TodoTaskService;
import com.app.mytodo.mytodo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/task")
public class TodoController {

    @Autowired
    private TodoTaskService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoTask> getAll() {
        return todoService.findAll();
    }

    @RequestMapping(value = "/{"+ Constants.ID_PRAM +"}", method = RequestMethod.GET)
    public TodoTask getById(@PathVariable(value = Constants.ID_PRAM) Integer id) {
        return todoService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public TodoTask create(@RequestBody TodoTask todo) {
        return todoService.create(todo);
    }

    @RequestMapping(value = "/{"+ Constants.ID_PRAM +"}", method = RequestMethod.PUT)
    public TodoTask update(@RequestBody TodoTask todo) {
        return todoService.update(todo);
    }

    @RequestMapping(value = "/{"+ Constants.ID_PRAM +"}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = Constants.ID_PRAM) Integer id) {
        todoService.delete(id);
    }
}
