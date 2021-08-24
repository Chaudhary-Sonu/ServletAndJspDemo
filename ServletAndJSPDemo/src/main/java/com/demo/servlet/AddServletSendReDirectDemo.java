package com.demo.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
 *	In case of requestDispatcher the browser does not know where the response is coming from, is it coming from Aservlet or Bservlet. What happens is, 
 		the client call Aservlet and then Aservlet calls Bservlet and the Bservlet returns the response. But, what if in a case like payment for you 
 		order - > where you browser redirects you from one site to another there, there the Aservlet send response back to client(browser) which again
 		makes a call to Bservlet. This concept is known as SendReDirect.
 		
 *	A RequestDispatcher forward() is used to forward the same request to another resource whereas ServletResponse sendRedirect() is a two step process. 
 		In sendRedirect(), web application returns the response to client with status code 302 (redirect) with URL to send the request.
 		
 *	We can achieve the concept of sendReDirect using the different tools:-
 			1. URL ReWriting
 			2. Session
 			3. Cookies
 */

@WebServlet("/SqSendReDirectDdemo")
public class AddServletSendReDirectDemo extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
			
		//This will be common for all, here first we'll have to accept the request or the value coming from the html page(basically, the input by the user).
		int i = Integer.parseInt(req.getParameter("noforsq1"));
		int j = Integer.parseInt(req.getParameter("noforsq2"));
		
		int k = i + j;
		
		
		/*EXAMPLE OF URL REWRITING
		/*
		 * This is an example of URL Rewriting Here, we just need to pass the request to the second servlet by rewriting the url(The URL that first servlet
		   		generated). We will be sending the URL as part of the response object. As, the sendRedirect is called by response object only.
		 * It ask the client(browser) that please call this servlet to perform this request. Above we just rewrited the request. But, we can also achieve
		  		the same thing by rewriting the URL in the browser ex:- "http://localhost:8081/ServletDemo/SqServReDdemo?i=5".
	     * Calling the second servlet
				res.sendRedirect("SqServReDdemo?k=" + k);
		
		
		/*EXAMPLE OF SESSION
		 * Session is given by Tomcat, it is usually available all through the servlet of the specific application.
		 * 		HttpSession session = req.getSession();
				session.setAttribute("k", k);
		 * If we want to remove the attribute that we have set in the session, we can use this.
				session.removeAttribute("k");
		 * Calling the second servlet
		 		res.sendRedirect("SqServReDdemo");
		 */
		
		
		//EXAMPLE OF COOKIE
		//since the second parameter also has to be a string, that's why adding + ""
		Cookie cookie = new Cookie("k", k + "");
		//Cookie is created in the AServ and send as part of response to client, then client send it as request to BServ.
		res.addCookie(cookie);
		
		res.sendRedirect("SqServReDdemo");
	}
}