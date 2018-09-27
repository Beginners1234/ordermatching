package businessLogic;

import org.junit.Test;

public class TestValidationImpl {
	
	ValidationImpl v=new ValidationImpl();
	
	@Test
	public void Authenticationcheck()
	{
		System.out.println("In Authenticationcheck");
		int result=v.Authenticationcheck("asnjd", "klcm");
		if(result==0)
			System.out.println("WRONG CREDENTIALS");
		else if(result==1)
			System.out.println("SUCCESSFUL LOGIN");
		else 
			System.out.println("UNIDENTIFIED ERROR");
	}
	
	@Test
	public void ValidateUser()
	{
		System.out.println("In ValidateUser");
		int result=v.ValidateUser("asnjd");
		if(result==0)
			System.out.println("USER ALREADY EXISTS");
		else if(result==1)
			System.out.println("USER VALIDATED");
		else 
			System.out.println("UNIDENTIFIED ERROR");
	}

}
