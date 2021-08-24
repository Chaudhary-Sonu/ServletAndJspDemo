package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * This is our servlet A, where we are performing the sum operation and for second operation that is square we'll be calling the second servlet
 * 		which is BServlet using the concept of RequestDispatcher.
 * 
 * And, also we'll be passing the data from it to the BServlet.
 */

@WebServlet("/sumsquare")
public class AServletRequestDispatcherDemo extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int i = Integer.parseInt(req.getParameter("n1"));
		int j = Integer.parseInt(req.getParameter("n2"));
		
		int k = i + j;
		//we'll be passing the value of k to the second servlet using "req" object.
		
		req.setAttribute("k", k);
		
		RequestDispatcher rd = req.getRequestDispatcher("sumsq");
		
		//Using this we are forwarding the req and res to BServlet.
		rd.forward(req, res);
	}
}