package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Content;
import model.ContentDAO;
/**
 * Servlet implementation class ContentServlet
 */
@WebServlet("/")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentDAO contentDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	contentDAO = new ContentDAO();
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch(action) {
				case "/new":
					//showNewFormContent
					break;
				case "/insert":
					//insertContent
					break;
				case "/update":
					//updateContent
					updateContent(request, response);
					break;
				case "/edit":
					//showEditFormContent
					showEditFormContent(request, response);
					break;
				case "/delete":
					//deleteContent
					deleteContent(request, response);
					break;
				case "/view":
					//listContent
					break;

			}
		} catch(SQLException  ex) {
			 throw new ServletException(ex);
		}
	}

	private void showEditFormContent(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
		int contentId = Integer.parseInt(request.getParameter("id"));
		Content content = contentDAO.selectContent(contentId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editContent.tiles");
		request.setAttribute("content", content);
		dispatcher.forward(request, response);
	}
	
	private void deleteContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			int contentId = Integer.parseInt(request.getParameter("id"));
			contentDAO.deleteContent(contentId);
			response.sendRedirect("main.tiles");
			
		}
	private void updateContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String brief = request.getParameter("brief");
			String content = request.getParameter("content");
			String updateDateTime =  LocalDateTime.now().toString();
			Content contentUpdate = new Content(id, title, brief, content, updateDateTime);
			contentDAO.updateContent(contentUpdate);
			response.sendRedirect("main.tiles");
			
		}

}
