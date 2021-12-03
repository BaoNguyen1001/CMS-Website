package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Content;
import beans.InfoEntity;
import model.ContentDAO;

/**
 * Servlet implementation class LoadViewContent
 */
@WebServlet("/LoadViewContent")
public class LoadViewContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadViewContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		
		  response.setContentType("text/html;charset=UTF-8"); 
		  ContentDAO contentDAO = new ContentDAO(); 
		  PrintWriter out = response.getWriter();
		  out.println( 
				  "     <div class=\"container-fluid\">\r\n"
		  		+ "        <div class=\"col-md-12\">\r\n"
		  		+ "            <div class=\"page-header\">\r\n"
		  		+ "                <h2>View Content</h2>\r\n"
		  		+ "            </div>\r\n"
		  		+ "\r\n"
		  		+ "            <hr />\r\n"
		  		+ "            <div class=\"card text-dark\">\r\n"
		  		+ "                <div class=\"card-header\">View Content List</div>\r\n"
		  		+ "                <div class=\"card-body\">\r\n"
		  		+ "                    <table class=\"table table-bordered table-striped table-responsive-md\">\r\n"
		  		+ "                        <thead>\r\n"
		  		+ "                            <tr>\r\n"
		  		+ "                                <th style=\"width: 10px;\">#</th>\r\n"
		  		+ "                                <th style=\"width:25%;\">Title</th>\r\n"
		  		+ "                                <th style=\"width:50%;\">Brief</th>\r\n"
		  		+ "                                <th>Created Date</th>\r\n"
		  		+ "                                <th>Action</th>\r\n"
		  		+ "                            </tr>\r\n"
		  		+ "                        </thead>\r\n"
		  		+ "                        <tbody>");
		  
		  try {
			  HttpSession session = request.getSession();
			  int userId = (int)session.getAttribute("loginUserId"); 
			  int count = contentDAO.countContentByAuthorId(userId);
			  int limit = 3;
			  int endPage = 0;
			  endPage = count / limit;
			  if(count % limit != 0) {
				  endPage++;
			  }
			  
			  List<Content> listContent = new ArrayList<Content>(); 
			  int index = Integer.parseInt(request.getParameter("index"));
			  int start = (index - 1) * limit;
			  listContent = contentDAO.selectAllContent(userId, start, limit); 
			  
			  int i = 0; 
			  for(Content content: listContent) { 
				  out.println("<tr>\r\n" 
						  + "                     	<td>"+ ++i +"</td>\r\n" 
						  + "                                	<td>"+content.getTitle()+"</td>\r\n" 
						  + "                                	<td>"+content.getBrief()+"</td>\r\n" 
						  + "                                	<td>\r\n" 
						  + "                                    	<span class=\"createdDate-date\">"+content.getCreateDateTime().substring(0, 10)+"</span>\r\n<br>" 
						  + "						<span class=\"createdDate-time\">"+content.getCreateDateTime().substring(11, 19)+"</span>\r\n"
						  + "                                	</td>\r\n" 
						  + "                                	<td>\r\n" 
						  + "                                    	<a class=\"editcontent\" href=\"edit?id="+content.getId()+ "\">Edit</a>\r\n" 
						  + "                                    	<a class=\"delcontent\" href=\"#\" data-id_xoa=\""+content.getId()+"\"  >Delete</button>\r\n"
						  + "                                	</td>\r\n" 
						  + "                            	</tr>");
						  
			  }
			  out.println("                            \r\n"
				  		+ "                        </tbody>\r\n"
				  		+ "                    </table>\r\n"
				  		+ "                </div>\r\n"
				  		+ "\r\n"
				  		+ "            </div>\r\n"
				  		+ "<br>\r\n"
				  		+ "<nav aria-label=\"Page navigation example\">\r\n"
				  		+ "		<ul class=\"pagination\">\r\n"
				  		);
			  
			  for(int j = 1; j <= endPage; j++) {
				  out.println("<li class=\"page-item\" id=\"${i}\"><a class=\"page-link\" href=\"\">"+j+"</a></li>");
			  }
			  
			  
			  out.println("                </ul>\r\n"
				  		+ "            </nav>"
					  	+ "        </div>\r\n"
				  		+ "    </div>\r\n"
				  		+ "<script src=\"./resources/js/myscript2.js\"></script"
				  		);
		  
		  } catch (SQLException e) 
		  { // TODO Auto-generated catch block
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
