<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse:collapse;
	border:1px solid blue;
}


</style>

</head>
<body>
<h3> 회원 정보 입력 폼 </h3>

<table border = "1">

<tr>
<td>회원ID</td>
<td><input type="text"><input type="button" value ="중복확인"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password"></td>
</tr>
<tr>
<td>비밀번호 확인</td>
<td><input type="password"></td>
</tr>
<tr>
<td>회원이름</td>
<td><input type="text"></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text"></td>
</tr>
<tr>
<td>회원주소</td>
<td><input type="text"></td>
</tr>
<tr>
<td>프로필 사진</td>
<td><input type="file"></td>
</tr>
<tr>
<td colspan="2" style="text-align:center;">
<button type="submit" value ="저장" class="tableLast">저장</button>
<button type="reset" value ="취소" class="tableLast">취소</button>
<button type="button" value ="회원목록" class="tableLast">회원목록</button>
</td>
</tr>



</table>
</body>
</html>