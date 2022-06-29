<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인</title>
</head>
<body>
	<form action="/jdbc/index">
		<input type="text" name="deptno" value="">
		<input type="submit" value="검색">
	</form>
	
	${requestScope.result}
</body>
</html>