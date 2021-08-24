package com.demo.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	1. Suppose you want that you Servlet should only work with post method. Then, instead of service method you can use 
 * 		doPost or doGet. If you chose doPost then you servlet will only work if it will receive a post request.
 * 
 * 	2. doGet() and doPost() are called from Service method only. 
 * 
 * 	3. You can also mention about the get and post type pf request in the html page, from which your servlet will be getting 
 * 		the inputs.
*/

@WebServlet("/multiply")
public class MultiplyServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int i = Integer.parseInt(req.getParameter("number1"));
		int j = Integer.parseInt(req.getParameter("number2"));
		
		int k = i * j;
		
		res.getWriter().println("The product is : " + k);
	}
}