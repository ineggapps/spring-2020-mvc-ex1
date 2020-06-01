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
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	font-size: 9pt;
	font-family: 맑은 고딕, 돋움;
}
</style>

</head>
<body>

<div style="width: 400px; margin:30px auto 5px; ">
<table style="width: 100%; border-spacing: 0px; border-collapse: collapse;">
	<tr height="35" style="border-top:2px solid #cccccc; border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">이름</td>
	   <td width="300" style="padding-left: 10px">
	         ${dto.name}
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">생년월일</td>
	   <td width="300" style="padding-left: 10px">
	         ${dto.birth}
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">띠</td>
	   <td width="300" style="padding-left: 10px">
	         ${dto.tti}
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">나이</td>
	   <td width="300" style="padding-left: 10px">
	         ${dto.age}
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">전화번호</td>
	   <td width="300" style="padding-left: 10px">
	         ${dto.phone}
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">기본급</td>
	   <td width="300" style="padding-left: 10px">
	       <fmt:formatNumber value="${dto.pay}" type="currency"/>
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">수당</td>
	   <td width="300" style="padding-left: 10px">
	       <fmt:formatNumber value="${dto.sudang}" type="currency"/>
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">세금</td>
	   <td width="300" style="padding-left: 10px">
	       <fmt:formatNumber value="${dto.tax}" type="currency"/>
	   </td>
	</tr>
	<tr height="35" style="border-bottom:2px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">실급여</td>
	   <td width="300" style="padding-left: 10px">
	       <fmt:formatNumber value="${dto.spay}" type="currency"/>
	   </td>
	</tr>
</table>
</div>

</body>
</html>