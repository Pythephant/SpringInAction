<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Register of Spittr</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resourse/style.css" />">
	
</head>
<body>
	<h1>Register</h1>
	<!--  This is the original one form tag of jstl 
	<form method="POST">
		First Name: <input type="text" name="firstName" /><br /> Last Name:
		<input type="text" name="lastName" /> <br /> UserName: <input
			type="text" name="username" /> <br /> Password: <input
			type="password" name="password" /> <br /> <input type="submit"
			value="Register" />
	</form>
	 -->

	<!-- 
	 	this is the SpringForm tag using to display the Annotation validation
	-->
	<sf:form method="POST" commandName="spitter">
		<sf:errors path="*" element="div" cssClass="errors"/>
		<sf:label path="firstName" cssErrorClass="error">FirstName:</sf:label>	<sf:input path="firstName" cssErrorClass="error"/>
		<!--<sf:errors path="firstName" cssClass="error"/> -->
		<br>
		LastName:	<sf:input path="lastName" />
		<sf:errors path="lastName" cssClass="error"/>
		<br>
		UserName:	<sf:input path="username" />
		<sf:errors path="username" cssClass="error"/>
		<br>
		Password:	<sf:password path="password" />
		<sf:errors path="password" cssClass="error"/>
		<br>
		<input type="submit" value="Register">
	</sf:form>


</body>

</html>