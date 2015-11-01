package src.main.java;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

public class DelegateTaskService implements JavaDelegate {

	public DelegateTaskService() {

	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {


		IdentityService identityService = execution.getEngineServices()
				.getIdentityService();
		TaskService tskService = execution.getEngineServices().getTaskService();
		TaskQuery tskQuery = tskService.createTaskQuery().taskUnassigned();
		GroupQuery grpQuery = identityService.createGroupQuery();
		UserQuery usrQuery = identityService.createUserQuery();
		List<Task> tskList = tskQuery.list();

	
		
		for (Task task : tskList) 
		{
			System.out.println("task" + task.getName());
			String Category = task.getCategory();
			List<Group> grpList = grpQuery.groupId(Category).list();
			for(Group grp : grpList)
			{
						UserQuery usrQuery1 = usrQuery.memberOfGroup(grp.getId());
						int lessNoOfTasks =1000;
						User lowTaskedUser = null;
						List<User> usrList = usrQuery1.list();
						for(User usr : usrList)
						{
							TaskQuery userTaskQuery = tskService.createTaskQuery().taskCandidateOrAssigned(usr.getId());
							int noOfTasks = userTaskQuery.list().size();
							if(noOfTasks < lessNoOfTasks)
							{
								lessNoOfTasks = noOfTasks;
								lowTaskedUser = usr;
							}
							
						}
						if(null!=lowTaskedUser)
						{
							System.out.println(lowTaskedUser.getFirstName()+ "lowTaskedUser Name");
							tskService.setAssignee(task.getId(), lowTaskedUser.getId());
						}
				
			}
			

			
		}

	}

}
