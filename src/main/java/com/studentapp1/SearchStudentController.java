package com.studentapp1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SearchStudentController extends GenericServlet {
    private Studentdao dao=new Studentdao();
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		int sid=Integer.parseInt(req.getParameter("sid"));
		
		Studentdto dto=dao.searchStudent(sid);
		if(dto!=null) {
			pw.println("<h2>Fetched Students Details are <a href='index.html'>Home</a></h2>");
			pw.println("<table border=5px>");
			pw.println("<tr><th>SID</th><th>SNAME</th><th>SPERC</th>");
			pw.println("<tr><td>"+dto.getSid()+"</td><td>"+dto.getSname()+"</td><td>"+dto.getSper()+"</td>");
			pw.println("</table>");
		}
		else {
			pw.println("<h2>Invalid Student id:  <a href='index.html'>Home</a></h2>");
		}
	}

}
