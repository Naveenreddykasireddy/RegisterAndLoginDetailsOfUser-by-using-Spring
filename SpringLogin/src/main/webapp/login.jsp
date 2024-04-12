<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<h1>Login</h1>
	<form:form action="userLogin" modelAttribute="user">
	<form:label path="email">Email</form:label>
	<form:input path="email"/>
	<br><br>
	<form:label path="password">Password</form:label>
	<form:input path="password"/>
	<input type="submit" value="Login">
	</form:form>
</body>
</html>