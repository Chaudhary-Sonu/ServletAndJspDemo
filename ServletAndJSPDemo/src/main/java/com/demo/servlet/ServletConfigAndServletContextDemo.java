package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Suppose, you need to pass some values to your servlet or some parameter then you can use this concept.
		Servletconfig is servlet specific, means you need to specify it for every servlet that you are using. Whereas, 
		ServletContext is common for all servlets, the parameter you set in servlet context will be available through out the servlets in you application.
 */

//@WebServlet("/ServletConfigAndServletContextDemo") -> this annotation is commented because for this one the configurations are there in web.xml
public class ServletConfigAndServletContextDemo extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		
		//Creating an object of ServletContext to get the value of Phone that we have setted in web.xml
		ServletContext ctx = getServletContext();
		String phoneValue = ctx.getInitParameter("Phone");
		out.println("The name of the Phone brand using ServletContext is " + phoneValue);
		
		
		//Creating an object of ServletConfig to get the value of Phone that we have setted in web.xml
		ServletConfig cg = getServletConfig();
		phoneValue = cg.getInitParameter("Phone");
		out.print("The name of the Phone brand using ServletConfig is " + phoneValue);
	}
}