package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.InfoEntity;
import model.InfoEntityFactory;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		InfoEntity info = new InfoEntity();
		info.setId(Integer.parseInt(request.getParameter("id")));
		info.setFirstname(request.getParameter("firstname"));
		info.setLastname(request.getParameter("lastname"));
		info.setUsername(request.getParameter("username"));
		info.setPassword(request.getParameter("password"));
		info.setEmail(request.getParameter("email"));
		info.setPhone(request.getParameter("phone"));
		info.setDescription(request.getParameter("description"));
		info.setCreatedDate(request.getParameter("createdDate"));
		info.setUpdateTime(request.getParameter("updateTime"));
		InfoEntityFactory.updateInfo(info);
		//response.sendRedirect(request.getContextPath() + "/ProfileServlet?id=" + info.getId());
		response.sendRedirect("main.tiles");
	}
}