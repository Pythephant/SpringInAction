<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Login of Spittr</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">

</head>
<body>
	<h1>Login</h1>
	<sf:form method="POST" action="login">
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>

			<tr>
				<td><input id="remember_me" name="remember-me" type="checkbox" />
					<label for="remember_me" class="inline">Remember Me</label></td>
				<td colspan='2'><input name="submit" type="submit"
					value="login" /></td>
			</tr>

		</table>
	</sf:form>


</body>

</html>