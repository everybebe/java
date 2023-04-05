<%@page import="kr.or.ddit.vo.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<%
	//컨트롤러(서블릿)에서 보내온 데이터 받기
	List<FileInfoVO> fileList = (List<FileInfoVO>) request.getAttribute("fileList");

%>

<h3>전체 파일 목록</h3>
<br><hr><br>
<a href="<%=request.getContextPath()%>/fileUpload.do">파일 업로드</a>
<table class="table table-success table-striped" border="1">
<thead>
	<tr><th>번호</th><th>작성자</th><th>저장 파일명</th><th>원래의 파일명</th>
	<th>파일 크기</th><th>날 짜</th><th>비 고</th></tr>
</thead>
<tbody>
<%
	if(fileList==null || fileList.size()==0) {
%>
	<tr><td colspan="7">저장된 파일 목록이 하나도 없습니다. </td></tr>
<% 	
	} else {
		for(FileInfoVO fvo : fileList) {
%>

	<tr>
		<td><%=fvo.getFile_no()%></td>
		<td><%=fvo.getFile_writer()%></td>
		<td><%=fvo.getSave_file_name() %></td>
		<td><%=fvo.getOrigin_file_name() %></td>
		<td><%=fvo.getFile_size() %></td>
		<td><%=fvo.getFile_date() %></td>
		<td><a href="<%= request.getContextPath()%>/fileDownload.do?fileno=<%= fvo.getFile_no()%>">Download</a></td>
		
	</tr>	

<%
		}
	}
%>

</tbody>

</table>





</body>
</html>