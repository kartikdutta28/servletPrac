package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database_layer.DaoOperations;
import model.Question;

/**
 * Servlet implementation class InsertQuestion
 */
public class InsertQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Question> questions=new ArrayList<Question>();
		String page=null;
		String t = request.getParameter("topic");
		if(t.equalsIgnoreCase("Date and Time")){
			page="date.jsp";
		}else if(t.equalsIgnoreCase("Strings and buffers")){
			page="strings.jsp";
		}else{
			page="thread.jsp";
		}
		if(request.getParameter("sub")!=null){
			if(questions.isEmpty()){
				Question question=new Question();
				question.setQuestion(request.getParameter("question"));
				question.setAnswer(request.getParameter("answer"));
				question.setTname(request.getParameter("topic"));
				questions.add(question);
				DaoOperations.addQuestions(questions);
				request.getRequestDispatcher("topics.jsp").forward(request, response);
			}else{
				Question question=new Question();
				question.setQuestion(request.getParameter("question"));
				question.setAnswer(request.getParameter("answer"));
				question.setTname(request.getParameter("topic"));
				questions.add(question);
				DaoOperations.addQuestions(questions);
				request.getRequestDispatcher("topics.jsp").forward(request, response);
			}
		}else if(request.getParameter("more")!=null){
			Question question=new Question();
			question.setQuestion(request.getParameter("question"));
			question.setAnswer(request.getParameter("answer"));
			question.setTname(request.getParameter("topic"));
			questions.add(question);
			request.getRequestDispatcher(page).forward(request, response);
		}else if(request.getParameter("back")!=null){
			response.sendRedirect("topics.jsp");
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
