<%@page import="kr.or.ddit.vo.lprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

List<lprodVO> lprodList = (List<lprodVO>) request.getAttribute("lprodList");

%>

<table border="1">
<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>
<%
	for(lprodVO lvo : lprodList) {
		

%>
	<tr><td><%=lvo.getLprod_id() %></td>
	<td><%=lvo.getLprod_gu() %></td>
	<td><%=lvo.getLprod_nm() %></td></tr>
<% 
}

%>
</table>

</body>
</html>