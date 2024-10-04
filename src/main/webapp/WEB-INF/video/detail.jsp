<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비디오 상세</title>
<style>
* {
    text-align: center;
    background-color: #f4f4f4;
}

h1{
	color: #00AE68;
}

#review-list, #video-detail {
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
	border-collapse: collapse;
	width: 100%;
	margin-bottom: 10px;
}

#review-list td, #review-list th, #video-detail td, #video-detail th {
	border: 1px solid black;
	padding: 10px;
}

.btn{
	text-decoration: none;
	background-color: #00AE68;
	color: #ffffff;
	text-align: center;
	border-radius: 5px;
	padding: 5px 10px;
}

a {
	text-decoration: none;
	color: #00AE68;
}

a:hover {
	background-color: #007B5F;
}
</style>
</head>
<body>
	<h1>비디오 상세</h1>
	<table id="video-detail">
		<thead>
			<tr>
				<th>제목</th>
				<th>운동부위</th>
				<th>채널이름</th>
				<th>영상보기</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${video.title}</td>
				<td>${video.part}</td>
				<td>${video.channelName}</td>
				<td><a class=btn href="${video.url}">바로가기</a></td>
			</tr>
		</tbody>
	
	</table>
	<c:if test="${reviewList.size() > 0}">
		<table id="review-list">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>내용</th>
					<th>작성일시</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reviewList}" var="review">
					<tr>
						<td>${review.id}</td>
						<td><a href="review?action=detail&id=${review.id}">${review.title}</a></td>
						<td>${review.writer}</td>
						<td>${review.content}</td>
						<td>${review.regDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>


	<a class=btn href="review?action=writeform&videoId=${video.id}">리뷰 추가</a>
</body>
</html>