package businessLogic;

import org.junit.Test;

public class TestValidationImpl {
	
	ValidationImpl v=new ValidationImpl();
	
	@Test
	public void Authenticationcheck()
	{
		System.out.println("In Authenticationcheck");
		int result=v.Authenticationcheck("pratyushsnehi10", "dsf");
		System.out.println(result);
		
		if(result==0)
		{
			System.out.println("WRONG CREDENTIALS");
		}
		else if(result==1)
			System.out.println("SUCCESSFUL LOGIN");
		else if(result == 2)
			System.out.println("Wrong login id");
		else
			System.out.println("UNIDENTIFIED ERROR");
	}
	
	@Test
	public void ValidateUser()
	{
		System.out.println("In ValidateUser");
		int result=v.ValidateUser("pratyushsnehi10");
		if(result==0)
			System.out.println("USER ALREADY EXISTS");
		else if(result==1)
			System.out.println("USER VALIDATED");
		else 
			System.out.println("UNIDENTIFIED ERROR");
	}

}
