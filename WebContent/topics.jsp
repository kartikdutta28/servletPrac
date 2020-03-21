<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Java FAQ Welcome Page</h1><br/>
	<% String s[]=(String [])session.getAttribute("topics");
	%><h1>Your chosen topics are</h1>
	<%
		for(String st:s){
			if(st!=null)
				out.println("<a href='TopicController?topic="+st+"'>"+st+"</a><br/>");
		}
	%>
</body>
</html>