<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>session</h1>
<div>${sessionScope.id}</div>
<div>${sessionScope.age}</div>
<div>${sessionScope.job}</div>

<a href="session/jobDelete.do">job ����</a> <br/>
<a href="session/sessionDelete.do">id, age ����</a> <br/>
<a href="index.jsp">index�� ���ư���</a>

</body>
</html>