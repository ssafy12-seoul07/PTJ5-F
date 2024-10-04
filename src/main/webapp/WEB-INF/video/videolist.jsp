<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
    text-align: center;
    background-color: #f4f4f4;
}

#video-list {
	box-shadow: 0 2px 5px rgba(0,0,0,0.1);
	border-collapse: collapse;
	width: 100%;
}

#video-list td, #video-list th {
	border: 1px solid black;
	padding: 5px;
}

h1{
	color: #00AE68;
}

a {
	text-decoration: none;
	color: #00AE68;
}

a:hover {
	color: #000000;
}

</style>
</head>
<body>
	<h1>SSAFIT💪</h1>
	<table id="video-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>운동부위</th>
				<th>채널이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${videoList}" var="video" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td><a href="video?action=videoDetail&videoId=${video.id}">${video.title}</a></td>
					<td>${video.part}</td>
					<td>${video.channelName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</body>
</html>