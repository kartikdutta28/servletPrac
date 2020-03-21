<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		session=request.getSession(false);
	%>
	<h1>Welcome Registered/LoggedIn User</h1><br/>
	<p>Your first name is </p><%= session.getAttribute("firstname")%><br/>
	<p>Your last name is </p><%= session.getAttribute("lastname")%><br/>
	<p>Your login name is </p><%= session.getAttribute("loginname")%><br/>
	<p>Your age is </p><%= session.getAttribute("age")%><br/>
	<p> Your chosen topics are </p><br/><%
		String s[]=(String [])session.getAttribute("topics");
		for(String st:s){
			if(st!=null)
				out.println("<p>" + st+ "</p><br/>");
		}
	%>
	<p>Go to <a href="topics.jsp">topics list page</a></p>
</body>
</html>