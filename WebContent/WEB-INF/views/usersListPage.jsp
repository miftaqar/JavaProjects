<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Users List</h1>
		<table border="1">
			<thead>
				<tr>
					<th>User Id</th>
					<th>Name</th>
					<th>Email Id</th>
			</thead>

			<tbody>
				<c:forEach var="user" items="${listOfUsers}" varStatus="status">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.emailId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>