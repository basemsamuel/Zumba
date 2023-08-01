package com.ZumbaProStudio.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		System.out.println("password "+password);
		System.out.println("repassword "+repassword);
		if (!password.equals(repassword)) {
			String message = "Passwords do Not Match";
			System.out.println(message);
			request.setAttribute("errorMessage", message);
			request.setAttribute("fname",fname);
			request.setAttribute("lname",lname);
			request.setAttribute("age",age);
			//Gender is not Selecting Saved value
			request.setAttribute("gender",gender);
			request.setAttribute("email",email);
			request.setAttribute("address",address);
			request.setAttribute("city",city);
			request.setAttribute("zipcode",zipcode);
			request.setAttribute("phone",phone);
			
			
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else if (email.isEmpty() || password.isEmpty() || fname.isEmpty() || lname.isEmpty() || age.isEmpty()) {
			String message = "Sorry!! All Fields Are Required To Register";
			System.out.println(message);
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else {
			int userage = Integer.parseInt(request.getParameter("age"));
			
			users user = new users();
			user.fname = fname;
			user.lname = lname;
			user.age = userage;
			user.gender = gender;
			user.email = email;
			user.address = address;
			user.city = city;
			user.zipcode = zipcode;
			user.phone = phone;
			user.password = password;
			
			DB db = new DB();
			String result = db.registerUser(user);
			db.closeConnection();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<center>");
			String message = "";
			
			if(result == "You have been added in database successfully, Please Login.") {
				request.setAttribute("errorMessage", result);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.setAttribute("fname",fname);
				request.setAttribute("lname",lname);
				request.setAttribute("age",age);
				//Gender is not Selecting Saved value
				request.setAttribute("gender",gender);
				request.setAttribute("email",email);
				request.setAttribute("address",address);
				request.setAttribute("city",city);
				request.setAttribute("zipcode",zipcode);
				request.setAttribute("phone",phone);
				request.setAttribute("errorMessage", result);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}

		}
	}

}
