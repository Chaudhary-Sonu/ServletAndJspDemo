package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

//This is an example of a basic servlet which 

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This is a normal class but when we extend any servlet to it, it becomes the Servlet.
		//This will be processing the request and sending the response.
@WebServlet("/add")
public class AddServlet extends HttpServlet {

	//Now it's a servlet and as per the life-servlet we have to use the "service()" method to perform the operation.
	//Servlet usually, deal with Request and Response.
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		/*
		 * HttpServletRequest req, HttpServletResponse res  --- >>> for these 2 we don't create an object, we just pass reference and 
		 * 		then further is handled by the tomacat-server, which provides us the object of these two.
		 */
		
		//Here the parameter will be in string format and we'll be using a name to fetch it
				//that name is the same name that we have use while creating a tag for the parameter in the html page.
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		//Now, till here we have got the request, we have extracted the parameter passed and performed the operation
				//that we had to and now comes printing the response on the web page or you can say server
				//(or returning the response). For that, we'll be using the below method.
		
		/*
		 * PrintWriter out = res.getWriter(); 
		 * out.println("The result is : " + k);
		 */
		
		//Or, we can directly use the below statement
		res.getWriter().println("The result is : " + k);
		
	}
}