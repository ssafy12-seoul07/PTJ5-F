<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 130px;
}
</style>
</head>
<body>
	<h1>유저 등록 결과</h1>
	<c:if test="${!empty userCount }">
		<h2>지금까지 등록한 유저 수 : ${userCount}</h2>
	</c:if>
	<h2>등록된 유저 정보</h2>
	<%-- c:if 태그를 이용해 request 영역에 user가 있다면 내용을 출력한다. --%>
	<c:if test="${!empty user }">
		<table>
			<thead>
				<tr>
					<th>항목</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>${user.id}</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>${user.nickname}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${user.password}</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<%-- c:if 태그를 이용해 request 영역에 user가 없다면 정보가 없음을 출력한다. --%>
	<c:if test="${empty user }">
		<p>등록된 유저가 없습니다.</p>
	</c:if>
	<!-- 다시 유저를 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.jsp">추가등록</a>
	<a href="./user?action=list">유저 목록</a>
</body>
</html>