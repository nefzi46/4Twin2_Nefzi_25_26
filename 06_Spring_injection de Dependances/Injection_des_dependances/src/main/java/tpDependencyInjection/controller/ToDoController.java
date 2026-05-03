package com.esprit.Dependency.tpDependencyInjection.controller;

import java.util.List;
import com.esprit.Dependency.tpDependencyInjection.services.ToDoService;

public class ToDoController {
	ToDoService toDoService;

	public List<String> getCoursesList() {
		return toDoService.getCoursesList();
	}
}
