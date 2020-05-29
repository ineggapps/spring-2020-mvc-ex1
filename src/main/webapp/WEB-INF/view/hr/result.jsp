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
<ul>
	<li>이름: ${dto.name}</li>
	<li>생일: ${dto.birth}</li>
	<li>띠: ${dto.zodiac}</li>
	<li>나이: ${dto.age}</li>
	<li>전화번호: ${dto.tel}</li>
	<li>기본급: <fmt:formatNumber type="currency" value="${dto.salary}"  pattern="¤#,###" currencySymbol="\\" /></li>
	<li>수당: <fmt:formatNumber type="currency" value="${dto.bonus}" pattern="¤#,###" currencySymbol="\\"   /></li>
	<li>세금: <fmt:formatNumber type="currency" value="${dto.tax}" pattern="¤#,###" currencySymbol="\\"  /></li>
	<li>실급여: <fmt:formatNumber type="currency" value="${dto.actualWage}" pattern="¤#,###" currencySymbol="\\"  /></li>
</ul>
</body>
</html>