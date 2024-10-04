<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 유저 관리</title>
<style>
label {
	display: inline-block;
	width: 130px;
}
</style>
</head>
<body>
	<h1>SSAFY 유저 관리</h1>
	<c:if test="${!empty userCount }">
		<h2>지금까지 등록한 유저 수 : ${userCount}</h2>
	</c:if>
	<form method="post" action="main">
		<fieldset>
			<legend>유저 정보 입력</legend>
			<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
			<input type="hidden" name="action" value="regist"> 
			<label for="id">id</label> 
			<input type="text" id="id" name="id"><br>
			<label for="nickname">닉네임</label> 
			<input type="text" id="nickname" name="nickname"><br> 
			<label for="password">비밀번호</label>
			<input type="password" id="password" name="password"><br> 
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
		</fieldset>
	</form>
</body>
</html>