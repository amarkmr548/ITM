package src.main.java;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

public class CreateTaskService implements JavaDelegate {

	public CreateTaskService() {

	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		//JDBCH2Service h2Service = new JDBCH2Service();
		// List<UserInfo> users = h2Service.getAllUsers();
//		IdentityService identityService = execution.getEngineServices()
//				.getIdentityService();
		TaskService tskService = execution.getEngineServices().getTaskService();
//		UserQuery userQry = identityService.createUserQuery();
//		List<User> usrList = userQry.list();
		String Name = (String) execution.getVariable("Name");
		String Description = (String) execution.getVariable("Description");
		String Category = (String) execution.getVariable("Category");
		
		Task newTask1 = tskService.newTask();
		newTask1.setDescription(Description);
		newTask1.setName(Name);
		newTask1.setCategory(Category);
		newTask1.setOwner("kermit");
		tskService.saveTask(newTask1);
		tskService.addCandidateGroup(newTask1.getId(), Category);
		
//		for (User ausr : usrList) {
//			
//			String id = ausr.getId();
//			TaskQuery tskQry = tskService.createTaskQuery();
//			List<Task>  tskList = tskQry.list();
//			
//			for(Task aTask: tskList)
//			{
//				
//			}
//			
//		}

	}

}
