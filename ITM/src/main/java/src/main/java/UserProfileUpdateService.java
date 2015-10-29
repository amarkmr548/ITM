package src.main.java;

import org.activiti.engine.IdentityService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

public class UserProfileUpdateService implements JavaDelegate {
	
	public UserProfileUpdateService()
	{
		
	}
	 
	   public void execute(DelegateExecution execution) throws Exception {
	 
		   IdentityService identityService =  execution.getEngineServices().getIdentityService();
		  
			 User user1 = identityService.newUser("prakash");
			 user1.setFirstName("prakash");
		     user1.setLastName("jana");
		     user1.setEmail("no-reply@activiti.org");
		 
		     identityService.saveUser(user1);
		   //  Group grp =  identityService.newGroup("IT");
		   //  identityService.createMembership("prakash", grp.getId());
		     
	   
	  }
	 

	

}
