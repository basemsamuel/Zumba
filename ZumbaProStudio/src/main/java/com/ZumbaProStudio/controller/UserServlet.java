package com.ZumbaProStudio.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		ServletContext application = getServletConfig().getServletContext();

		String htmlFormName = request.getParameter("htmlFormName");
		System.out.println("String:" + htmlFormName);
		System.out.println("AddBatch".equals(htmlFormName));
		String message = "";
		
		if ("UserViewBatches".equals(htmlFormName)) {
			String cid = (String) application.getAttribute("userid");
			
			DB db = new DB();
			//When using array
//			ArrayList<batchInfo> batches = db.viewBatchFromDB();
//			batches.forEach(cRef -> System.out.println(cRef));
			
			//When using String
			String batchTableDate = db.viewUserBatchFromDB(cid);
			System.out.println(batchTableDate);
			//Loop Through the Array and generate Table Html 
	        db.closeConnection();

	        String username = (String) application.getAttribute("username"); 
	        request.setAttribute("customerUsername", username);
	        
			request.setAttribute("batchTableDate", batchTableDate);
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			
		} if (htmlFormName.contains("SignUpBatch_")) {
			int bid = Integer.parseInt(htmlFormName.split("_")[1]);
			System.out.println("Batch bid: " + bid);

			String cid = (String) application.getAttribute("userid");
			String username = (String) application.getAttribute("username"); 
			System.out.println("User cid: " + cid);
			
			String batchTableDate = "";
			String BatchTableErrorMessage = "";
			if(cid != null && bid > 0) {
				DB db = new DB();
				
				//Try To Delete The Batch
				BatchTableErrorMessage = db.addbatchSignup(bid, cid);
				
				//Refresh Table Data
				batchTableDate = db.viewUserBatchFromDB(cid);
				
				db.closeConnection();
				
			} 
			
	        request.setAttribute("batchTableDate", batchTableDate);
			request.setAttribute("BatchTableErrorMessage", BatchTableErrorMessage);
			request.setAttribute("customerUsername", username);
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			
		} if (htmlFormName.contains("UnregisterFromBatch_")) {
			int bid = Integer.parseInt(htmlFormName.split("_")[1]);
			System.out.println("Batch bid: " + bid);

			String cid = (String) application.getAttribute("userid");
			String username = (String) application.getAttribute("username"); 
			System.out.println("User cid: " + cid);
			
			String batchTableDate = "";
			String BatchTableErrorMessage = "";
			if(cid != null && bid > 0) {
				DB db = new DB();
				
				//Try To Delete The Batch
				BatchTableErrorMessage = db.UnregisterFromBatch(bid, cid);
				
				//Refresh Table Data
				batchTableDate = db.viewUserBatchFromDB(cid);
				
				db.closeConnection();
				
			} 
			
	        request.setAttribute("batchTableDate", batchTableDate);
			request.setAttribute("BatchTableErrorMessage", BatchTableErrorMessage);
			request.setAttribute("customerUsername", username);
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
		} else {
			response.getWriter().append("htmlFormName:" + htmlFormName);
			System.out.println("htmlFormName:" + htmlFormName);		
		}
		
	}

}