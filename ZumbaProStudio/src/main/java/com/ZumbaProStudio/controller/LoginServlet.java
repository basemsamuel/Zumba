package com.ZumbaProStudio.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginFilter
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (email.isEmpty() || password.isEmpty() ) {
			String message = "Sorry!! All Fields Are Required To Login";
			System.out.println(message);
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			System.out.println("email: "+email+"  password: "+password);
			if ("admin".equals(email) && "passWord#".equals(password)) {
				//Admin Login
				DB db = new DB();
				
				//Refresh Table Data
				String batchTableDate = db.viewBatchFromDB();
	 
		        db.closeConnection();

				request.setAttribute("batchTableDate", batchTableDate);
				request.getRequestDispatcher("/admin.jsp").forward(request, response);
				
			} else {
				users user = new users();
				user.email = email;
				user.password = password;
				
				DB db = new DB();
				String result = db.LoginUser(user);
				db.closeConnection();
				
				if(!result.contains("ErrorCode") ) {
					
					ServletContext application = getServletConfig().getServletContext();  
					String username = result.split("_")[0];
					String cid = result.split("_")[1];
					application.setAttribute("username", username); 
					application.setAttribute("userid", cid);
					String globalUsername = (String) application.getAttribute("username"); 
					System.out.println("globalUsernameL "+globalUsername);
					System.out.println("globalUserIDL " + cid);
					String globalUserID = (String) application.getAttribute("id"); 

					
					//Refresh Table Data
					DB db2 = new DB();
					String batchTableDate = db2.viewUserBatchFromDB(cid);
			        db.closeConnection();
			        request.setAttribute("batchTableDate", batchTableDate);
			        
					request.setAttribute("customerUsername", username);
					request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

				} else {
					
					request.setAttribute("errorMessage", result);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}

		}
	}

}
