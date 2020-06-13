<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form id="loginForm" modelAttribute="login" action="login"
		method="post">
		<table>

			<tr>
				<td><form:label path="userName" name="userName" id="userName">User Name</form:label>
				</td>
				<td><form:input path="userName" name="userName" id="userName" />
				</td>
			</tr>


			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" name="password" id="password" />
				</td>
			</tr>
			<tr>
				<td><form:button id="login" name="login">Login</form:button></td>
			</tr>

		</table>
	</form:form>

	<table>
		<tr>
			<td style="color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>