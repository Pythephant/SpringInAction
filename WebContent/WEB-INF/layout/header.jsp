<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="<s:url value="/" />"><img
	src="<s:url value="/resources" />/images/spitter_logo_50.png"
	border="0" /></a>
<a href="<s:url value="/login" />">Login</a>
|
<a method="POST" href="<s:url value="/logout" />">Logout </a>

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.username" var="username" />
	|    Hi~ <a href="<c:url value="/spitter/${username }" />">${username }
	</a>
</security:authorize>