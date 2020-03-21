<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Date and Time</h1>
	<form action="InsertQuestion">
		Enter Question Here<textarea name="question" rows="10" cols="30"></textarea><br/>
		Enter Answer here<textarea name="answer" rows="10" cols="30"></textarea><br/>
		<input type="hidden" value="Date and Time" name="topic">
		<input type="submit" value="Submit" name="sub"><input type="submit" value="Enter more" name="more">
		<input type="submit" value="Back" name="back">
	</form>
</body>
</html>