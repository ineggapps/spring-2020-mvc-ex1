<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=cp %>/user8/request" method="post">
		<p> 	이름: <input type="text" name="name" /> </p>
		<p> 	나이: <input type="text" name="age" /> </p>
		<p> 취미: 
			<input type="checkbox" name="hobby" value="운동"/> 운동하기 
			<input type="checkbox" name="hobby" value="음악"/> 음악감상 
			<input type="checkbox" name="hobby" value="웃기"/> 수업시간에 웃기
			<input type="checkbox" name="hobby" value="영화"/> 영화감상
			<input type="checkbox" name="hobby" value="여행"/> 여행하기 
	 	</p>
	 	<p>
	 		<button type="submit">확인</button>
	 	</p>
	</form>
</body>
</html>