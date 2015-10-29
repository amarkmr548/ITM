package src.main.java;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

public class ITMService implements JavaDelegate {

	public ITMService() {

	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		// JDBCH2Service h2Service = new JDBCH2Service();
		// List<UserInfo> users = h2Service.getAllUsers();
		IdentityService identityService = execution.getEngineServices()
				.getIdentityService();
		TaskService tskService = execution.getEngineServices().getTaskService();
		UserQuery userQry = identityService.createUserQuery();
		List<User> usrList = userQry.list();

		Task newTask = tskService.newTask();
		newTask.setDescription("Ticket 1 group 1");
		tskService.saveTask(newTask);
		
		Task newTask1 = tskService.newTask();
		newTask.setDescription("Ticket 2 group 2");
		tskService.saveTask(newTask1);
	
		
		for (User ausr : usrList) {
			
			String id = ausr.getId();
			TaskQuery tskQry = tskService.createTaskQuery();
			List<Task>  tskList = tskQry.list();
			
			for(Task aTask: tskList)
			{
				
			}
			
		}

	}

}
