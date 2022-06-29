<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@page import="org.springframework.web.bind.annotation.PathVariable"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<%
	Cookie cookie1 = new Cookie("id", "test");
	cookie1.setMaxAge(60 * 60);
	response.addCookie(cookie1);
	
	//Customer : String id, int age
	session.setAttribute("id", "spring-session");
	session.setAttribute("age", 29);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>Cookie API Test</h3>
	<a href="cookieTest.do">cookieTest.do</a>
	<hr>
	<h3>Session API Test</h3>
	<a href="session/sessionTest1.do">1. session/sessionTest1.do</a>
	<hr>
	<a href="session/sessionTest2.do?id=spring&age=29">2. session/sessionTest2.do : DTO ��ü�� ���ǿ� ����</a>
	<hr>
	<h3>�α��� �Ϸ� ����</h3>
	
	<c:choose>
		<c:when test="${sessionScope.admin == null}">
			<a href="session/loginForm.do"><button>�α���</button></a>
		</c:when>
		<c:when test="${sessionScope.admin != null }">
			<a href="session/logout.do"><button>�α׾ƿ�</button></a>
			<br/>
			${sessionScope.admin }�� �α��� �����Ͽ����ϴ�!
		</c:when>
	</c:choose>
	
		<hr>
</body>

</html>