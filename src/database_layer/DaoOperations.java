package database_layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Question;
import model.User;

public class DaoOperations {
	public static DaoService ds=new DaoService();
	 public static int save(User u){
		 int status=0;
		try{
			String topics=String.join(",", u.getTopics());
			Connection con=ds.openConnection();
			String sql="insert into user_infov1 values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getLoginName());
			ps.setInt(4, u.getAge());
			ps.setString(5,u.getPwd());
			ps.setString(6, topics);
			status =ps.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	 }
	 public static User isExists(String loginname,String pwd){
		 User user=null;
		 try{
			 Connection con=ds.openConnection();
			 String sql="select * from user_infov1 where login_name=? and password=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, loginname);
			 ps.setString(2, pwd);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 user=new User();
				 user.setFirstName(rs.getString(1));
				 user.setLastName(rs.getString(2));
				 user.setLoginName(rs.getString(3));
				 user.setAge(rs.getInt(4));
				 user.setPwd(rs.getString(5));
				 String topics[]=rs.getString(6).split(",");
				 user.setTopics(topics);
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	 }
	 
	 public static int addQuestions(List<Question>questions){
		 int status=0;
		 Connection connection;
		try {
			connection = ds.openConnection();
			PreparedStatement ps=connection.prepareStatement("insert into question_v1 values(?,?,?,?)");
			for(Question question:questions){
				ps.setString(1, question.getQid());
				ps.setString(2, question.getQuestion());
				ps.setString(3, question.getAnswer());
				ps.setString(4, question.getTname());
				status=ps.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return status;
	 }
	 
}
