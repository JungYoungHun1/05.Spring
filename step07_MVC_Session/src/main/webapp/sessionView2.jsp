<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>���ǿ� ����� Customer</h3>
${sessionScope.customer.id } - ${sessionScope.customer.age }
<hr>
<a href="session/customerDelete.do">customer ����</a> <br/>
<a href="index.jsp">index�� ���ư���</a>

</body>
</html>