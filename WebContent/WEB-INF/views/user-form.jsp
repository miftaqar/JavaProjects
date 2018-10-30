<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
	<div align="center">
		<form:form action="processForm" method="post"
			modelAttribute="userForm">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Spring MVC Form Demo -
							Registration</h2></td>
				</tr>
				<tr>
					<td>User Name :</td>
					<td><form:input path="userName" /> <form:errors
							path="userName" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td>EmailId :</td>
					<td><form:input path="emailId" /></td>
				</tr>
				<tr>
					<td>Date of Birth (DD/MM/YYYY) :</td>
					<td><form:input path="birthDate" /></td>
				</tr>
				<tr>
					<td>Profession :</td>
					<td><form:select path="profession">
							<form:option value="" label="Please Select Profession"></form:option>
							<form:options items="${professionList}" />
							<form:errors path="profession" cssStyle="color: #ff0000;" />
						</form:select></td>
				</tr>
				<tr align="center">
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>