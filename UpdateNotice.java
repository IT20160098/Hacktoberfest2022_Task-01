package com.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UpdateNotice
 */
@WebServlet("/UpdateNotice")
public class UpdateNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("noticeid");
		String title = request.getParameter("title");
		String des = request.getParameter("des");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		
		
		boolean isTrue;
		 isTrue =NoticeDBUtil.updatenotice(id,title,des,phone,email,date);
		 
		 if(isTrue == true) {
			 List<Notice> noticeDetails = NoticeDBUtil.getNoticeDetails(id); 
			 request.setAttribute("noticeDetails", noticeDetails);
			 
			 RequestDispatcher dis = request.getRequestDispatcher("noticeaccount.jsp");
			 dis.forward(request, response);
		 }
		 else {
			 List<Notice> noticeDetails = NoticeDBUtil.getNoticeDetails(id); 
			 request.setAttribute("noticeDetails",noticeDetails);
			 
			 
			 RequestDispatcher dis = request.getRequestDispatcher("noticeaccount.jsp");
			 dis.forward(request, response); 
		 }
	}

}
