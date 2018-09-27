package businessLogic;

public interface Validation {
	
	public int Authenticationcheck(String loginid, String passwrd);
	public int ValidateUser(String loginid);
}
