package java.tpDependencyInjection.services;

import java.util.List;
import com.esprit.Dependency.tpDependencyInjection.dao.IToDoDao;


public class ToDoService {
	
	private IToDoDao toDo;

	public List<String> getCoursesList() {
		return toDo.getCoursesList();
	}
}
