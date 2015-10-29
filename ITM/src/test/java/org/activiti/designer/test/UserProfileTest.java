package org.activiti.designer.test;



import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

public class UserProfileTest {

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	@Test
	public void createUser() throws Exception {
	IdentityService identityService = activitiRule.getIdentityService();
	 User user1 = identityService.newUser("kathir");
	 user1.setFirstName("kathir");
     user1.setLastName("govind");
     user1.setEmail("no-reply@activiti.org");
     identityService.saveUser(user1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
