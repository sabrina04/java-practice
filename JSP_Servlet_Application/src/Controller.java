

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.DBHelper;
import user.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/project")
	private DataSource dataSource;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page;
		if(request.getParameterMap().containsKey("page")) {
			page = request.getParameter("page");
		}
		else {
			page = "index";
		}
		
		switch(page) {
			case("index"):
				Home(request, response);
				break;
			case("add_user"):
				AddUser(request, response);
				break;
			case "submitUser":
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				User user = new User(name,email);
			    submitUser(user,request,response);
			case("list_users"):
				ListUsers(request, response);
				break;
			case "updateUser":
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				try {
					updateUser(user_id,request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "deleteUser":
				int user_id1 = Integer.parseInt(request.getParameter("user_id"));
				deleteUser(user_id1, request, response);
				break;
			default:
				Error(request, response);
				break;
		}
	}
	
	private void deleteUser(int user_id, HttpServletRequest request, HttpServletResponse response) {
		  
        try {
      	new DBHelper().deleteUser(user_id,dataSource);
			ListUsers(request, response);
		} catch (ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void updateUser(int user_id, HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		if(request.getParameterMap().containsKey("action")){
			if(request.getParameter("action").equals("submit")){
				
				//update record code goes here
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				User tempUser = new User(user_id,name,email);
				try {
					new DBHelper().updateUser(tempUser,dataSource);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				request.setAttribute("message", "Record updated");
			    request.getRequestDispatcher("message.jsp").forward(request, response);
			}
		}else{
			//Create a user reference
			User user = null;
			//Read user from DBHelper
	        try {
				user = new DBHelper().getUser(user_id,dataSource);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       //set the attribute
	       request.setAttribute("user", user);
	       request.getRequestDispatcher("update_user.jsp").forward(request, response);
		}
	}

	private void submitUser(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			new DBHelper().addUser(user, dataSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("submitted_user.jsp").forward(request, response);
		
	}

	private void Error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

	private void ListUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = null;
		try {
			userList = new DBHelper().getUsers(dataSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("list_users.jsp").forward(request, response);
	}

	private void AddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add_user.jsp").forward(request, response);		
	}

	private void Home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);		
	}



}
