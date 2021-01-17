package com.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.dao.TodoDao;
import com.springboot.web.model.Todo;

@Service
public class TodoService {
	
	@Autowired
	TodoDao todoDao;
	
    //private static List<Todo> todos = new ArrayList<Todo>();
    //private static int todoCount = 3;

    /* static {
        todos.add(new Todo(1, "Asreet", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "Asreet", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "Asreet", "Learn Hibernate", new Date(),
                false));
    } */

    public List<Todo> retrieveTodos(String user) {
    	List<Todo> allTodos = (List<Todo>) todoDao.findAll();
    	List<Todo> usersTodos = new ArrayList<>();;
    	for(Todo t: allTodos) {
    		if(user.equals(t.getUser())) {
    			usersTodos.add(t);
    		}
    	}
    	return usersTodos;
    }
    
    public Todo retrieveTodo(int id) {
    	Todo t = todoDao.findOne(id);
    	return t;
    }

    public void updateTodo(Todo todo){
    	todoDao.delete(todo.getId());
    	todoDao.save(todo);
    }

    public void addTodo(String name, String taskName, String desc, Date startDate, Date endDate,
            boolean isDone, String email, String severity) {
        todoDao.save(new Todo(name,taskName, desc, startDate, endDate, isDone, email, severity));
    }

    public void deleteTodo(int id) {
    	todoDao.delete(id);
        
    }
}