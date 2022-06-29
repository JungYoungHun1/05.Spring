<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>view</title>
</head>
<body>
	<h2>view</h2>
	
	${requestScope.id } - ${requestScope.age } <br/>
	${param.id }
</body>
</html>