package com.demo.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SqServReDdemo")
public class SqServletSendReDirectDemo extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int sq = 0;
		
		/*  EXAMPLE of URL-ReWriting -> 
		 *  we have passed the value by writing it as part of URL and here we're extracting it from the URl
		 		sq = Integer.parseInt(req.getParameter("k"));
		 */
		
		
		/* EXAMPLE of SESSION -> 
		 * passing the value through a session
		  		HttpSession session = req.getSession();
				sq = (int) session.getAttribute("k");
		 */
		
		
		//EXAMPLE OF COOKIES
		//in request we have a method getCookies instead of a single cookie, because there can be many cookies in the request. So, we'll get all the cookies
				//in an array of cookies.
		Cookie cookie[] = req.getCookies();
		//now to get our data we'll be using a loop to get the data we have added to the cookie
		for(Cookie c : cookie) {
			if(c.getName().equals("k")) {
				sq = Integer.parseInt(c.getValue());
			}
		}
		
		sq *= sq;
		
		//res.getWriter().print("The response in case of SendReDirect by URL Rewriting is : " + sq);
		//res.getWriter().print("The response in case of SendReDirect using SESSION is : " + sq);
		res.getWriter().print("The response in case of SendReDirect using COOKIES is : " + sq);
	}
}