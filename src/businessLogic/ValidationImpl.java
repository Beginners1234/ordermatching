package businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MyConnection;

public class ValidationImpl implements Validation {

	@Override
	public int Authenticationcheck(String loginid, String passwrd) {
		// TODO Auto-generated method stub
		String CHECKPSWRD="SELECT password FROM user_details where login_id=?";
		int num = 0;//password wrong
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(CHECKPSWRD);
			ps.setString(1, loginid);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				String pswd = set.getString("password");
				if(pswd == passwrd)
				{
					num = 1;//successful user
				}
				else
				{
					break;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			num = 2;//such loginId does not exist
		}
		return num;

	}

	@Override
	public int ValidateUser(String loginid) {
		// TODO Auto-generated method stub
		
		String CHECKLOGINID="SELECT COUNT(*) FROM user_details where login_id=?";
		int num = 0;
		try(Connection con = MyConnection.openConnection();) {
			PreparedStatement ps = con.prepareStatement(CHECKLOGINID);
			ps.setString(1, loginid);
			int count = ps.executeUpdate();
			if(count == 0)
			{
				num = 1; // user doesn't exist ... registration successful
			}
			else
			{
				num = 0; // user already exist... please change login id
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			num = 2; // unidentified error
		}
		return num;

		
	}

}
