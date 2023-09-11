package com.studentapp1;

import java.io.IOException;
import java.io.PrintWriter;
																																				
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AddStudentController extends GenericServlet {

	private Studentdao dao = new Studentdao();

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String msg = "";
		int sid = Integer.parseInt(req.getParameter("sid"));
		String sname = req.getParameter("sname");
		double sperc = Double.parseDouble(req.getParameter("sperc"));

		Studentdto dto = new Studentdto(sid, sname, sperc);

		if (dao.addStudent(dto)) 
		{
			msg = "<h1>Student added Successfully....<a href='index.html'>home</a></h1>";
		} else {
			msg = "<h1>Something Went Wrong....<a href='index.html'>home</a></h1>";
		}
		pw.println(msg);
	}

}
