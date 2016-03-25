<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Document - List</title>
</head>
<body>
	<h2>My Documents</h2>
	<p>
		<button type="button" onClick="location.href='create'">Add New</button>
	</p>
	<table border="1" cellspacing="1" cellpadding="5">
		<thead>
			<tr>
				<th>Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${documents}" var="doc" >
			<tr>
				<td><c:out value="${doc.name}"/></td>
				<td>
					<a href="${doc.id}/show">Detail</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>