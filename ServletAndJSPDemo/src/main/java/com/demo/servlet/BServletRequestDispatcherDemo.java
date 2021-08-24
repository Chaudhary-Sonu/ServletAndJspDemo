package com.demo.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sumsq")
public class BServletRequestDispatcherDemo extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//Type casting the req object to int data type.
		int sq = (int) req.getAttribute("k");
		
		sq *= sq;
		
		res.getWriter().println("The square of the sum is : " + sq);
	}
}