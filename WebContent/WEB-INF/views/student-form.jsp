<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC - Student Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName" />

		<br>
		<br>
		
		Last Name: <form:input path="lastName" />

		<br>
		<br>

		Country: <form:select path="country">
			<form:options items="${student.countryOptions}" />

		</form:select>

		<br>
		<br>

		Subject: <form:select path="subject">
			<form:options items="${theSubjectOptions}" />

		</form:select>

		<br>
		<br>
		
		Favourite Programming Language:
		<br>

		<form:radiobutton path="favoriteLanguage" value="Java" /> Java 
		<form:radiobutton path="favoriteLanguage" value="PHP" /> PHP 
		<form:radiobutton path="favoriteLanguage" value="C#" /> C# 
		<form:radiobutton path="favoriteLanguage" value="Ruby" /> Ruby

		<br>
		<br>
		
		Student Age: <form:radiobuttons path="age"
			items="${student.ageOptions}" />

		<br>
		<br>
		
		Operating System:
		<br> 
		Linux <form:checkbox path="operatingSystems" value="Linux" /> 
		MAC OS <form:checkbox path="operatingSystems" value="Mac OS" />
		Windows Linux <form:checkbox path="operatingSystems" value="Windows" />

		<br>
		<br>

		<input type="submit" value="Submit">

	</form:form>
</body>
</html>