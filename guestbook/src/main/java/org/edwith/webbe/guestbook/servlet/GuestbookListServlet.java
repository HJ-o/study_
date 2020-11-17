package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {
	/*
	 * 왜 HttpServlet에게 Serialize하라고 하는가?
	 * https://stackoverflow.com/questions/179743/why-does-httpservlet-implement-serializable
	 *  */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 참고: https://best421.tistory.com/27
    	
    	GuestbookDao guestbookDao = new GuestbookDao();
    	List<Guestbook> list = guestbookDao.getGuestbooks();
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/guestbook/guestbooks.jsp"); 
    	request.setAttribute("list", list);
    	dispatcher.forward(request, response); 
    }

}
