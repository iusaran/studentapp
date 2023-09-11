package com.studentapp1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DeleteStudentController extends GenericServlet {
	private Studentdao dao = new Studentdao();

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String msg = "";
		int sid = Integer.parseInt(req.getParameter("sid"));
		
		if (dao.deleteStudent(sid)) 
		{
			msg = "<h1>Student deleted Successfully....<a href='index.html'>home</a></h1>";
		} else {
			msg = "<h1>Something Went Wrong....<a href='index.html'>home</a></h1>";
		}
		pw.println(msg);
	}

}


