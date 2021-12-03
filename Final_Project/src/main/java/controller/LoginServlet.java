package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import beans.LoginUser;
import common.CookieUtils;
import model.LoginDAO;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = CookieUtils.get("email", request);
		
		if(email != null && !email.equals("")) {
			
			LoginDAO loginDAO = new LoginDAO();
			int userId = loginDAO.getId(email);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userId);
			response.sendRedirect("main.tiles");
			//request.getRequestDispatcher("/main.tiles").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginUser user = new LoginUser();
			BeanUtils.populate(user, request.getParameterMap());
			LoginDAO loginDAO = new LoginDAO();
			
			boolean checklogin = loginDAO.checkLogin(user.getEmail(), user.getPassword());
			if(checklogin) {
				int userId = loginDAO.getId(user.getEmail());
				
				HttpSession session = request.getSession();
				session.setAttribute("loginUserId", userId);
				
				if(user.isRemember()) {
					CookieUtils.add("email", user.getEmail(), 2, response);
				} else {
					CookieUtils.add("email", user.getEmail(), 0, response);
				}
				
				if (loginDAO.loginFirstTime(userId) == true) {
					response.sendRedirect("main.tiles");
				}
				else {
					response.sendRedirect("ProfileServlet?id=" + userId);
				}
				
			} else {
				request.setAttribute("mess", "Wrong email or pass");
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
				return;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
