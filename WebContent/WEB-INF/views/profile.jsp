<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
	<br /> firstName:
	<c:out value="${spitter.firstName}" />
	<br /> lastName:
	<c:out value="${spitter.lastName}" />

	<p>------------------------cut the line--------------------------</p>
	<c:url var="saveSpittle" value="/spittles/saveSpittle" />
	<sf:form method="POST" action="${saveSpittle }"
		modelAttribute="spittle">
		<sf:label path="message">Enter Spittle:</sf:label>
		<sf:textarea path="message" rows="3" cols="40" />
		<sf:errors path="message"></sf:errors>
		<sf:hidden path="username" value="${spitter.username}" />
		<input type="submit" value="Spit It" />
	</sf:form>

	<p>------------------------cut the line--------------------------</p>
	<div>
		<c:forEach items="${spittleList}" var="thisspittle">
			<li id="thisspittle_<c:out value="thisspittle.id"/>">
				<div class="spittleMessage">
					<c:out value="${thisspittle.message}" />
				</div>
				<div>
					<span class="spittleTime"><c:out value="${thisspittle.time}" /></span>
					<span class="spittleLocation"> (<c:out
							value="${thisspittle.latitude}" />, <c:out
							value="${thisspittle.longitude}" />)
					</span>
				</div>
			</li>
		</c:forEach>
	</div>
</body>
</html>