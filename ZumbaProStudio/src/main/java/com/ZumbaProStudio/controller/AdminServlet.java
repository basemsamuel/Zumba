package com.ZumbaProStudio.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String htmlFormName = request.getParameter("htmlFormName");
		response.getWriter().append("Served at: ").append(htmlFormName);
		System.out.println(htmlFormName);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String htmlFormName = request.getParameter("htmlFormName");
		System.out.println("String:" + htmlFormName);
		System.out.println("AddBatch".equals(htmlFormName));
		String message = "";
		
		if ("AddBatch".equals(htmlFormName)) {
			System.out.println("Entered AddBatch");
			String name = request.getParameter("name");
			String stime = request.getParameter("stime");
			String etime = request.getParameter("etime");
			String M = request.getParameter("M");
			String Tu = request.getParameter("Tu");
			String W = request.getParameter("W");
			String Th = request.getParameter("Th");
			String F = request.getParameter("F");
			String S = request.getParameter("S");
			String Su = request.getParameter("Su");
			int capacity = Integer.parseInt(request.getParameter("capacity"));
			String description = request.getParameter("description");
			System.out.println("name " + name);
			System.out.println("stime " + stime);
			System.out.println("etime " + etime);
			System.out.println("capacity " + capacity);
			System.out.println("description " + description);
			
			if (M == null && Tu == null && W == null && Th == null && F == null && S == null && Su == null) {
				message = "Please Pick A At Least One Day Of The Week ! ErrorCode: A01";
				request.setAttribute("name",name);
				request.setAttribute("stime",stime);
				request.setAttribute("etime",etime);
				request.setAttribute("capacity",capacity);
				request.setAttribute("description",description);
				request.setAttribute("batcherrorMessage", message);
				request.getRequestDispatcher("/addbatch.jsp").forward(request, response);
			} else if (name.isEmpty() || stime.isEmpty() || etime.isEmpty() || capacity == 0 || description.isEmpty()) {
				request.setAttribute("name",name);
				request.setAttribute("stime",stime);
				request.setAttribute("etime",etime);
				request.setAttribute("capacity",capacity);
				request.setAttribute("description",description);
				request.setAttribute("M", M);
				request.setAttribute("Tu", Tu);
				request.setAttribute("W", W);
				request.setAttribute("Th", Th);
				request.setAttribute("F", F);
				request.setAttribute("S", S);
				request.setAttribute("Su", Su);
				message = "Please Enter All Fields !  ErrorCode: A02";
				request.setAttribute("batcherrorMessage", message);
				request.getRequestDispatcher("/addbatch.jsp").forward(request, response);
			} else {
				batchInfo batch = new batchInfo();
				batch.name = name;
				batch.stime = stime;
				batch.etime = etime;
				batch.capacity = capacity;
				batch.description = description;

				String days = "";
				if (M != null) {
					days = M;
				}
				if (Tu != null) {
					if (days.length()>0) {
						days = days + ",";
					}
					days = days + Tu;
				}
				if (W != null) {
					if (days.length()>0) {
						days = days + ",";
					}
					days = days + W;
				}
				if (Th != null) {
					if (days.length()>0) {
						days = days + ",";
					}
					days = days + Th;
				}
				if (F != null) {
					if (days.length()>0) {
						days = days + ",";
					}
					days = days + F;
				}
				if (S != null) {
					if (days.length()>0) {
						days = days + ",";
					}
					days = days + S;
				}
				if (Su != null) {
					if (days.length()>0) {
						days = days + ",";
					}
					days = days + Su;
				}
				batch.days = days;			
				
				DB db = new DB();
				String result = db.addBatchToDB(batch);
				db.closeConnection();
				
				if(result == "Batch Added!") {
					request.setAttribute("batcherrorMessage", result);
					request.getRequestDispatcher("/addbatch.jsp").forward(request, response);
				} else {
					request.setAttribute("name",name);
					request.setAttribute("stime",stime);
					request.setAttribute("etime",etime);
					request.setAttribute("capacity",capacity);
					request.setAttribute("description",description);
					request.setAttribute("batcherrorMessage", result);
					request.getRequestDispatcher("/addbatch.jsp").forward(request, response);
				}
				
			}
			
		} else if ("ViewBatches".equals(htmlFormName)) {
			DB db = new DB();
			//When using array
//			ArrayList<batchInfo> batches = db.viewBatchFromDB();
//			batches.forEach(cRef -> System.out.println(cRef));
			
			//When using String
			String batchTableDate = db.viewBatchFromDB();
			System.out.println(batchTableDate);
			//Loop Through the Array and generate Table Html 
	        db.closeConnection();

			request.setAttribute("batchTableDate", batchTableDate);
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		} else if (htmlFormName.contains("DeleteBatch_")) {
			int bid = Integer.parseInt(htmlFormName.split("_")[1]);
			System.out.println("Deleting bid: " + bid);
			
			DB db = new DB();
			
			//Try To Delete The Batch
			String BatchTableErrorMessage = db.deleteBatchFromDB(bid);
			
			//Refresh Table Data
			String batchTableDate = db.viewBatchFromDB();
 
	        db.closeConnection();

			request.setAttribute("batchTableDate", batchTableDate);
			request.setAttribute("BatchTableErrorMessage", BatchTableErrorMessage);

			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		} else if ("ViewUsers".equals(htmlFormName)) {
			
			DB db = new DB();
			String userListTableDate = db.viewUsersFromDB();
			System.out.println(userListTableDate);
			//Loop Through the Array and generate Table Html 
	        db.closeConnection();

			request.setAttribute("userListTableDate", userListTableDate);
			request.getRequestDispatcher("/adminusers.jsp").forward(request, response);
		} else if (htmlFormName.contains("DeleteUser_")) {
			int cid = Integer.parseInt(htmlFormName.split("_")[1]);
			System.out.println("Deleting bid: " + cid);
			
			DB db = new DB();
			
			//Try To Delete The Batch
			String UserTableErrorMessage = db.deleteUserFromDB(cid);
			
			//Refresh Table Data
			String userListTableDate = db.viewUsersFromDB();
			System.out.println(userListTableDate);
			//Loop Through the Array and generate Table Html 
	        db.closeConnection();

			request.setAttribute("userListTableDate", userListTableDate);
			request.setAttribute("UserTableErrorMessage", UserTableErrorMessage);

			request.getRequestDispatcher("/adminusers.jsp").forward(request, response);
		} 
		else {
			response.getWriter().append("htmlFormName:" + htmlFormName);
			System.out.println("htmlFormName:" + htmlFormName);			
		}
	}

}
