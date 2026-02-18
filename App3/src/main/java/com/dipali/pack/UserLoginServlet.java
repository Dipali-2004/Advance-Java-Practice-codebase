package com.dipali.pack;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String username = req.getParameter("uname");
		String password = req.getParameter("pwd");
		
		UserBean bean=new UserLoginDAO().login(username, password);
		if(bean==null)
		{
			req.setAttribute("msg","Invalid login Credentials");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			ServletContext context=req.getServletContext();
			context.setAttribute("userBean", bean);
			Cookie ck =new Cookie("ck1",bean.getU_fname());
			res.addCookie(ck);
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		
	}

}
