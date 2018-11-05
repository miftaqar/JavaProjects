<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring - Internationalization</title>
</head>
<body>
	<h2>Welcome</h2>
	<h2>${welcome_msg}</h2>
	<hr />
	<a id="en"
		href="<%=request.getContextPath()%>/SpringMvcInternationalization/init?lang=en">English
	</a> |
	<a id="en"
		href="<%=request.getContextPath()%>/SpringMvcInternationalization/init?lang=fr">French
	</a>
	<div></div>

	<div id="welcome_text">
		<h4>
			<spring:message code="welcome.message"></spring:message>
		</h4>

	</div>


</body>
</html>