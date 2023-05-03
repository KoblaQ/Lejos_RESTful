<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='../updatemessage' method='post'>
		<input type='number' name='id' value='${requestScope.displayMessage.id }'>
		<input type='text' name='message' value='${requestScope.displayMessage.message }'>
		<input type='submit' name='ok' value='OK'>
	</form>

</body>
</html>