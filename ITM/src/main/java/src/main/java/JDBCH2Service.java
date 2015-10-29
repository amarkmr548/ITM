package src.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCH2Service {
	
	public List<UserInfo > getAllUsers()
	{
		List<UserInfo> userInfo = new ArrayList<UserInfo>();
		try
		{
			 Connection connection= DriverManager.getConnection("jdbc:h2:mem:activiti");
			   Statement s=connection.createStatement();
			   /*  try {
			    s.execute("DROP TABLE PERSON");
			    } catch(SQLException sqle) {
			        System.out.println("Table not found, not dropping");
			    }*/
			    //s.execute("CREATE TABLE PERSON (ID INT PRIMARY KEY, FIRSTNAME VARCHAR(64), LASTNAME VARCHAR(64))");
			    PreparedStatement ps=connection.prepareStatement("select * from ACT_ID_USER");
			    ResultSet r=ps.executeQuery();
			   while(r.next())
			   {
				   UserInfo uinfo = new UserInfo();
				   String id = r.getString("ID_");
				   uinfo.setId(id);
				   userInfo.add(uinfo);
			   }
			    r.close();
			    ps.close();
			    s.close();
			    connection.close();
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return userInfo;
		
	}
	

}
