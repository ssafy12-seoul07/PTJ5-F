<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"	 uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
<style>
    body {
        background-color: #f4f4f4;
        margin: 20px;
    }

    h2 {
        color: #00AE68;
    }

    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    input[type="text"], textarea {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="submit"] {
        background-color: #00AE68;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #007B5F;
    }
</style>
</head>
<body>
	<h2>리뷰 등록</h2>
	<form action="review" method="POST">
		<input type="hidden" name="action" value="write">
		<input type="hidden" name="videoId" value="${videoId}">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			작성자 : <input type="text" name="writer" value="익명">
		</div>
		<div>
			내용 : <textarea rows="10" cols="30" name="content"></textarea>
		</div>
		<div>
			<input type="submit" value="리뷰 등록">
		</div>
	</form>
</body>
</html>