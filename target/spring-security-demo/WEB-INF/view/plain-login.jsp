<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.failed {
	color: red;
}
</style>
</head>
<body>
	<h3>My Custom Login Form</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		<!-- Check for login error -->
		<c:if test="${param.error != null}">
			<i class="failed">Sorry, You entered invalid username or password</i>
		</c:if>
		<p>
			UserName: <input type="text" name="username">
		</p>
		<p>
			Password: <input type="password" name="password">
		</p>

		<input type="submit" value="Submit">
	</form:form>
</body>
</html>