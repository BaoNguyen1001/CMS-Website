package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Register;
import model.RegisterDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		
		Register user = new Register(username, email, password);
		HttpSession session = req.getSession();

		RequestDispatcher rd;

		boolean checkUsername = RegisterDAO.checkUsername(user);
		if(checkUsername)
		{
			req.setAttribute("msg", "Username was exist");
			RequestDispatcher rs = req.getRequestDispatcher("view/register.jsp");
			rs.forward(req, resp);
		}
		else {
			boolean checkEmail = RegisterDAO.checkEmail(user);
			if(checkEmail)
			{
				req.setAttribute("msg", "Email was exist");
				RequestDispatcher rs = req.getRequestDispatcher("view/register.jsp");
				rs.forward(req, resp);
			}
			else {				
				if(!password.equals(repassword)) {
					req.setAttribute("msg", "Repassword incorrect");
					RequestDispatcher rs = req.getRequestDispatcher("view/register.jsp");
					rs.forward(req, resp);
				} 
				else {
					
					try {
						
						if(RegisterDAO.insertRegister(user)) {
							req.setAttribute("email", user.getEmail());
							req.setAttribute("msg2", "Register success!");
							rd = req.getRequestDispatcher("view/login.jsp");
							rd.forward(req, resp);
						}
						else {
							req.setAttribute("msg", "Was error when register!");
							rd = req.getRequestDispatcher("view/register.jsp");
							rd.forward(req, resp);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				
		}


	}

}
