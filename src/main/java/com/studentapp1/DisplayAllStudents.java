package com.studentapp1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DisplayAllStudents extends GenericServlet
{
    private Studentdao dao=new Studentdao();
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
     		resp.setContentType("text/html");
     		PrintWriter pw=resp.getWriter();
     		
     		List<Studentdto> students=dao.getAllStudents();
     		pw.println("<h2><a href='index.html'>Home</a></h2>");
     		pw.println("<table border=5>");
     		pw.println("<tr><th>SID</th><th>SNAME</th><th>SPERC</th>");
     		for(Studentdto dto:students)
     		{
     			pw.println("<tr><td>"+dto.getSid()+"</td><td>"+dto.getSname()+"</td><td>"+dto.getSper()+"</td>");
     		}
     		pw.println("</table>");
	}

}
