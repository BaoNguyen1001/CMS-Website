package controller;

import java.awt.Dialog;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Content;
import model.AddContent;
import model.ContentDAO;

/**
 * Servlet implementation class addContent_Controller
 */
@WebServlet("/addContent_Controller")
public class addContent_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private AddContent cntModel;
	 public addContent_Controller() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	 public void init() {
	    	cntModel = new AddContent();
	    }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");
		int authorid = Integer.parseInt(request.getParameter("authorid"));
		String createDateTime = LocalDateTime.now().toString();
		String updateDateTime = LocalDateTime.now().toString();
		System.out.println(title + " "+ brief + " " + content + " " + authorid + " " + createDateTime.toString() + " "+ updateDateTime.toString() );
		
		Content ContentMD = new Content();
		ContentMD.setTitle(title);
		ContentMD.setBrief(brief);
		ContentMD.setContent(content);	
		ContentMD.setAuthorid(authorid);
		ContentMD.setCreateDateTime(createDateTime);
		ContentMD.setUpdateDateTime(updateDateTime);
		
		cntModel.Insert(ContentMD);
		response.sendRedirect("/Final_Project/addContent.tiles");
	}
}
