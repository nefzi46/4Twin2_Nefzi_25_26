package com.esprit.Dependency.tpDependencyInjection.services;

import java.util.List;
import com.esprit.Dependency.tpDependencyInjection.dao.IToDoDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
	private IToDoDao toDo;

	public List<String> getCoursesList() {
		return toDo.getCoursesList();
	}
}
