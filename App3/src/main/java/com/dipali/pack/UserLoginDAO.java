package com.dipali.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserLoginDAO 
{
	public UserBean login(String userName,String password)
	{
		UserBean ub=null;
		try
		{
			Connection con =DBConnect.getcon();
			System.out.println("Database connection: " + (con != null ? "Success" : "Failed"));
			
			PreparedStatement pstmt =con.prepareStatement("select * from registration where USERNAME=? and PASSWORD=?");
			pstmt.setString(1,userName);
			pstmt.setString(2,password);
			
			System.out.println("Executing query with username: " + userName);
			ResultSet rs=pstmt.executeQuery();
			 
			 if(rs.next())
			 {
				  ub = new UserBean();
				 ub.setU_name(rs.getString(1));
				 ub.setU_pwd(rs.getString(2));
				 ub.setU_fname(rs.getString(3));
				 ub.setU_lname(rs.getString(4));
				 ub.setU_mail(rs.getString(5));
				 ub.setU_phone(rs.getString(6));


			 }

			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in userLoginDAO");
			e.printStackTrace();
		}
		return ub;
	}

}
