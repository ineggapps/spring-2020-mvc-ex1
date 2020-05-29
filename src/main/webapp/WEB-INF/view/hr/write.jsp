<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String cp=request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=cp%>/hr/request" method="post">
	<ul>
		<li>이름: <input type="text" name="name" value="홍길동" /></li>
		<li>생년월일: <input type="text" name="birth" value="2000-10-10" /></li>
		<li>전화번호: <input type="text" name="tel" value="010-111-1111" /></li>
		<li>기본급: <input type="text" name="salary" value="2500000" /></li>
		<li>수당: <input type="text" name="bonus" value="100000" /></li>
	</ul>
	<p><button type="submit">등록하기</button></p>
	</form>
</body>
</html>