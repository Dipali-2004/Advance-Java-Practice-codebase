package com.dipali.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class UserRegistrationDAO
{
	public int insert_UserData(UserBean ub)
	{
		int rowCount=0;
		try
		{
			Connection con =DBConnect.getcon();
			PreparedStatement pstmt =con.prepareStatement("insert into registration values(?,?,?,?,?,?)");
			pstmt.setString(1,ub.getU_name());
			pstmt.setString(2,ub.getU_pwd());
			pstmt.setString(3,ub.getU_fname());
			pstmt.setString(4,ub.getU_lname());
			pstmt.setString(1,ub.getU_mail());
			pstmt.setString(1,ub.getU_phone());
			
			rowCount=pstmt.executeUpdate();
			
		}
		catch(SQLIntegrityConstraintViolationException s)
		{
			s.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
		
	}

}
