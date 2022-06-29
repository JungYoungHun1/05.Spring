<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>세션에 저장된 Customer</h3>
${sessionScope.customer.id } - ${sessionScope.customer.age }
<hr>
<a href="session/customerDelete.do">customer 삭제</a> <br/>
<a href="index.jsp">index로 돌아가기</a>

</body>
</html>