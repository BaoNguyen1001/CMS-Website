package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class SearchControl
 */
@WebServlet("/ViewController")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			HttpSession session = request.getSession();
			
			String txtSearch = request.getParameter("txtSearch");
			int authorid =  (int) session.getAttribute("loginUserId");
			
			ContentDAO contentDAO = new ContentDAO();
			int count = contentDAO.countSearchContent(txtSearch, authorid);
			int limit = 10;
			int endPage = 0;
			endPage = count / limit;
			if(count % limit != 0) {
				endPage++;
			}
			int index = Integer.parseInt(request.getParameter("index"));
			request.setAttribute("index", index);
			index = (index - 1) * limit;
			List<Content> listSearch = contentDAO.seachContentByTitle(txtSearch, authorid, index, limit);
				
			request.setAttribute("endPage", endPage);
			request.setAttribute("listSearch", listSearch);
			request.setAttribute("txtSearch", txtSearch);
			
			request.getRequestDispatcher("viewContent.tiles").forward(request, response);				

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
