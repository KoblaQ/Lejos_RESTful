<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='../addmessage' method='post'>
		<input type='number' name='id' value=''> <input type='text'
			name='message' value=''> <input type='submit' name='ok'
			value='OK'>
	</form>
	<ol>
		<c:forEach var="message" items="${requestScope.messagelist }">
			<li>${displayMessage}<a
				href='../deletemessage?id=${displayMessage.id}'>Delete</a> <a
				href='../readtoupdatemessage?id=${displayMessage.id}'>Update</a>
		</c:forEach>
	</ol>

</body>
</html>