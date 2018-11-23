<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Lists</title>
 <script type="text/javascript">
         
            function getConfirmation(){
               var retVal = confirm("Do you want to continue ?");
               if( retVal == true ){
                  return true;
               }
               else{
                  return false;
               }
            }
         
      </script>
</head>
<body>
	<div align="center">
		<h1>Contacts List</h1>
		<a href="newContact">New Contact</a>
		<table border="1">
			<thead>
				<tr>
					<th>S. No</th>
					<th>Contact Id</th>
					<th>Name</th>
					<th>Email Id</th>
					<th>Address</th>
					<th>Telephone</th>
					<th>Action</th>
			</thead>

			<tbody>
				<c:forEach var="contact" items="${contacts}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>CLMVC-${contact.id}</td>
						<td>${contact.name}</td>
						<td>${contact.email}</td>
						<td>${contact.address}</td>
						<td>${contact.telephone}</td>
						<td><a href="editContact?id=${contact.id}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="deleteContact?id=${contact.id} ">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="../../">Back To Home Page</a>
	</div>
</body>
</html>