<%@page import="webMemberTest.vo.memberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.6.4.min.js" type="text/javascript"></script>

<title>Insert title here</title>

<style type="text/css">
table {

	border:1px solid blue;
}


</style>

<script type="text/javascript">

    $(document).ready(function() {
        $('#memAdd').click(function() {
            window.location.href = 'meminsert.jsp';
        });
    });
</script>
</head>

<body>

	<%
		//컨트롤러(서블릿)에서 보내온 데이터 받기
		List<memberVO> memList = (List<memberVO>) request.getAttribute("memList");
	
	%>


<h3>회원 목록 보기</h3>
<br>
<form action="">
<table border="1" width="500px">

<tr>
	<th colspan="5" style="text-align:right;">
	<input type ="button" value="회원추가" id="memAdd" onClick="memAdd" >
	</th>	
</tr>

<tr>
<th>ID</th>
<th>비밀번호</th>
<th>이 름</th>
<th>전 화</th>
<th>주 소</th>
</tr>

<% 
for(memberVO vo : memList) { 
%>

<tr>
<td><%=vo.getMem_id()%></td>
<td><%=vo.getMem_pass()%></td>
<td><%=vo.getMem_name()%></td>
<td><%=vo.getMem_tel()%></td>
<td><%=vo.getMem_addr() %></td>
</tr>

<% 
}
%>

</form>
</body>
</html>