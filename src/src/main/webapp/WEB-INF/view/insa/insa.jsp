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
.btn {
	 font-size: 12px;
	 color:#333;
 	 font-weight:500;
	 font-family: NanumGothic, 나눔고딕, "Malgun Gothic", "맑은 고딕", 돋움, sans-serif;
	 border:1px solid #ccc;
	 background-color:#FFF;
	 vertical-align:middle;
	 text-align:text-align;
	 cursor:pointer;
	 padding:4px 8px;
	 border-radius:4px;
	 margin-bottom: 3px;
}
.btn:active, .btn:focus, .btn:hover {
	 background-color:#e6e6e6;
	 border-color: #adadad;
	 color: #333;
}
.boxTF {
	border:1px solid #999;
	padding:4px 6px;
	border-radius:4px;
	background-color:#ffffff;
	font-family: NanumGothic, 나눔고딕, "Malgun Gothic", "맑은 고딕", 돋움, sans-serif;
	font-size: 9pt;
}
</style>

<script type="text/javascript">
function isValidDate(data) {
    var regexp = /[12][0-9]{3}[\.|\-|\/]?[0-9]{2}[\.|\-|\/]?[0-9]{2}/;
    if(! regexp.test(data))
        return false;

    regexp=/(\.)|(\-)|(\/)/g;
    data=data.replace(regexp, "");
    
	var y=parseInt(data.substr(0, 4));
    var m=parseInt(data.substr(4, 2));
    if(m<1||m>12) 
    	return false;
    var d=parseInt(data.substr(6));
    var lastDay = (new Date(y, m, 0)).getDate();
    if(d<1||d>lastDay)
    	return false;
		
	return true;
}

function isValidKorean(data){
	var format = /^[\uac00-\ud7a3]*$/g;
    return format.test(data);
}

function sendOk() {
	var f=document.forms[0];
	var format, s;
	
	s=f.name.value;
	s=s.trim();
	if(! s || ! isValidKorean(f.name.value)) {
		alert("이름을 입력 하세요.");
		f.name.focus();
		return;
	}
	f.name.value=s;
	
	if(! isValidDate(f.birth.value)) {
		alert("생년월일을 정확히 입력 하세요(yyyy-mm-dd).");
		f.birth.focus();
		return;
	}
	
	format=/^(01[016789])-[0-9]{3,4}-[0-9]{4}$/g;
	if(! format.test(f.phone.value)) {
		alert("전화번호를 정확히 입력 하세요.");
		f.phone.focus();
		return;
	}
	
	// format=/^(\d+)$/;
	format=/^\d{6,8}$/;
	if(! format.test(f.pay.value)) {
		alert("기본급여는 6~8자리의 숫자만 가능 합니다.");
		f.pay.focus();
		return;
	}
	
	format=/^\d{1,7}$/;
	if(! format.test(f.sudang.value)) {
		alert("수당은 1~7자리의 숫자만 가능 합니다.");
		f.sudang.focus();
		return;
	}
	
	f.submit();
}
</script>

</head>
<body>

<div style="width: 400px; margin:30px auto 5px; ">
<form action="<%=cp%>/insa/request" method="post">
<table style="width:100%; border-spacing: 0px; border-collapse: collapse;">
	<tr height="35" style="border-top:2px solid #cccccc; border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">이름</td>
	   <td width="300" style="padding-left: 10px">
	         <input type="text" name="name" class="boxTF">
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">생년월일</td>
	   <td width="300" style="padding-left: 10px">
	         <input type="text" name="birth" class="boxTF">
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">전화번호</td>
	   <td width="300" style="padding-left: 10px">
	         <input type="text" name="phone" class="boxTF">
	   </td>
	</tr>
	<tr height="35" style="border-bottom:1px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">기본급</td>
	   <td width="300" style="padding-left: 10px">
	         <input type="text" name="pay" class="boxTF">
	   </td>
	</tr>
	<tr height="35" style="border-bottom:2px solid #cccccc;">
	   <td width="100" align="right" style="padding-right: 5px">수당</td>
	   <td width="300" style="padding-left: 10px">
	         <input type="text" name="sudang" class="boxTF" value="0">
	   </td>
	</tr>
    <tr height="40" align="center">
       <td colspan="2"><button type="button" class="btn" onclick="sendOk()"> 등록하기 </button> </td>
    </tr>
</table>
</form>
</div>

</body>
</html>