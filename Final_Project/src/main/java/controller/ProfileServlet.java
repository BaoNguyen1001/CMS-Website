package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.InfoEntity;
import model.InfoEntityFactory;
import conn.web.MysqlConnection;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		MysqlConnection.testConnect();
		int userId = Integer.parseInt(request.getParameter("id"));
		InfoEntity info = InfoEntityFactory.getInfoById(userId);
		request.setAttribute("id", info.getId());
		request.setAttribute("firstname", info.getFirstname());
		request.setAttribute("lastname", info.getLastname());
		request.setAttribute("username", info.getUsername());
		request.setAttribute("password", info.getPassword());
		request.setAttribute("email", info.getEmail());
		request.setAttribute("phone", info.getPhone());
		request.setAttribute("description", info.getDescription());
		request.setAttribute("createdDate", info.getCreatedDate());
		request.setAttribute("updateTime", info.getUpdateTime());
		request.getRequestDispatcher("edit.tiles").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}