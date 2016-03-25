<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Document</title>
<style>
	.error {
		color : red;
	}
	.error-field {
		border: 1px solid red;
	}
</style>
</head>
<body>
	<form:form commandName="document" method="post">
		<p>
			<label>ID</label>
			<form:input path="id" cssErrorClass="error-field"/>
			<form:errors path="id" cssClass="error"/>
		</p>
		<p>
			<label>Document Name</label>
			<form:input path="name" cssErrorClass="error-field"/>
			<form:errors path="name" cssClass="error"/>
		</p>
		<p>
			<input type="submit" value="Add New"/>
		</p>
	</form:form>
</body>
</html>