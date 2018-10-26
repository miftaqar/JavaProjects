<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">

<script
	src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Spring Application</h2>
	<p>Welcome to Spring MVC Demo Application</p>
	<img alt="Spring Logo"
		src="${pageContext.request.contextPath}/resources/images/Spring-Logo.png"
		width="100" height="100" />

	<br>
	<br>
	<a href="hello/showForm">Hello World Form</a>

	<br>
	<br>
	<a href="student/showForm">Student Form</a>
	
	<br>
	<br>
	<a href="customer/showForm">Customer Form</a>
	
	<br>
	<br>
	<input type="button" onclick="doSomeWork()" value="Click Me" />

</body>
</html>