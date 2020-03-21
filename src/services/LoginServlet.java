package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import database_layer.DaoOperations;

import model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		RequestDispatcher rd;
		PrintWriter out=response.getWriter();
		String loginname=request.getParameter("loginname");
		String pwd=request.getParameter("pwd");
		User user=DaoOperations.isExists(loginname, pwd);
		if(user!=null){
			HttpSession session=request.getSession();
			session.setAttribute("firstname", user.getFirstName());
			session.setAttribute("lastname", user.getLastName());
			session.setAttribute("loginname", user.getLoginName());
			session.setAttribute("age", user.getAge());
			session.setAttribute("pwd", user.getPwd());
			session.setAttribute("topics", user.getTopics());
			rd=request.getRequestDispatcher("userinfo.jsp");
			rd.forward(request, response);
		}else{
			out.write("<p>Wrong username of password please register first</p>");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		doGet(request, response);
	}

}
