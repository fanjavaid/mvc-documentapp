<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${document.name} - Detail</title>
</head>
<body>
	<h2>Document</h2>
	<ul>
		<li>ID : ${document.id}</li>
		<li>Document Name : ${document.name}</li>
		<li>Created At : ${document.createdAt}</li>
	</ul>
</body>
</html>