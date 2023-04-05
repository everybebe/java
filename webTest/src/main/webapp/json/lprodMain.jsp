<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.4.min.js"></script>
<title>Insert title here</title>

<script>

$(function(){
	$('#lprodBtn').on('click', function(){

	
	$.ajax({
		
		url : '<%= request.getContextPath() %>/lprodList.do',
		type : 'post',
		
		success : function(res){
			

				code = "<table class='table table-bordered table-sm' border='1'>";
				code += "<tr class='table-success'><td>lprod_id</td><td>lprod_gu</td><td>lprod_nm</td></tr>";
				
			$.each(res, function(i,v) {
				code += "<tr><td>" + v.lprod_id + "</td>";
				code += "<td>" + v.lprod_gu + "</td>";
				code += "<td>" + v.lprod_nm + "</td></tr>";
				
			});
			
			code += "</table>";
		
			$('#result').html(code);
			
		},
		
		error : function(xhr) {
			alert ("상태 : " + xhr.status);
		},
		
		dataType : 'json'
	
	});
	

});
	
	
	$("#lprodBtn2").on('click', function(){
		location.href = "<%= request.getContextPath()%>/lprodList2.do";
	});

});

</script>
</head>
<body>

<!-- 
	아래의 'Lprod자료 가져오기'버튼을 클릭하면 DB의 LPROD테이블의 전체 데이터를 가져와
	id가 'result'인 <div>태그에 표로 출력하시오
	(Ajax이용, MVC패턴 사용, 서블릿의 URL패턴 : /lprodList.do)

 -->

 
 <form>
  <input type="button" id="lprodBtn" value ="Lprod자료 가져오기(Ajax이용)">
  <input type="button" id="lprodBtn2" value ="Lprod자료 가져오기(Non Ajax)">
 </form>
 
 <h3>Lprod 자료 목록</h3>
 
 <div id = "result"></div>
</body>
</html>