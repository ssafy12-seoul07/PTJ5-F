<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세 페이지</title>
<style>
    body {
        background-color: #f4f4f4;
    }
    
    .box {
    	background-color: #FFFFFF;
        margin: 20px;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    h2 {
        color: #00AE68;
        margin: 20px;
    }

    .review-title {
        font-size: 24px;
        font-weight: bold;
        margin-bottom: 10px;
    }

    .review-content {
        font-size: 16px;
        margin-bottom: 20px;
    }

    a {
        text-decoration: none;
        color: #00AE68;
        margin-right: 15px;
        padding: 8px 12px;
        border: 1px solid #00AE68;
        border-radius: 4px;
    }

    a:hover {
        background-color: #00AE68;
        color: white;
    }
</style>
</head>
<body>
	<h2>리뷰 상세</h2>
	<div class="box">
		<div class="review-title">${review.title }</div>
		<div class="review-content">${review.content }</div>
		
		<a href="review?action=delete&id=${review.id}">삭제</a>
		<a href="review?action=updateform&id=${review.id}">수정</a>
	</div>
</body>
</html>