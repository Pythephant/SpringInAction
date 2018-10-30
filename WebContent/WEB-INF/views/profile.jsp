<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Your Profile</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>
		<c:out value="${spitter.username} " />
		's Profile
	</h1>
	Id:
	<c:out value="${spitter.id}" />
	<br /> 
	firstName:
	<c:out value="${spitter.firstName}" />
	<br />
	lastName:<c:out value="${spitter.lastName}" />
</body>
</html>