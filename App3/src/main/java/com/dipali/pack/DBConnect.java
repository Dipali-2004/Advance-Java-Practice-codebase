package com.dipali.pack;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect
{
	static Connection con =null;
	static
	{
		
	try
	{
		Class.forName(DBinfo.driver);
		 con=DriverManager.getConnection(DBinfo.dbUrl,DBinfo.dbUname,DBinfo.dbPwd);
	}
	catch(Exception e)
	{
        System.out.println("Exception occured in DbConnect calss");
        e.printStackTrace();
	}

}

public static Connection getcon()
{
	return con;
}
}
