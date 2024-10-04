package com.ssafy.review.controller;

import java.io.IOException;

import com.ssafy.review.model.dto.Review;
import com.ssafy.review.model.service.ReviewService;
import com.ssafy.review.model.service.ReviewServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ReviewService service = ReviewServiceImpl.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "like":
			doLike(request, response);
			break;
		case "dislike":
			doDislike(request, response);
			break;
		case "writeform": 
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		case "updateform":
			doUpdateForm(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		default:
			System.out.println("에러페이지로 가라");
			break;
		}
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Review review = service.getReview(Integer.parseInt(request.getParameter("id")));
		review.setTitle(request.getParameter("title"));
		review.setContent(request.getParameter("content"));
		
		service.modifyReview(review);
		
		response.sendRedirect("video?action=videoDetail&videoId=" + review.getVideoId());
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Review review = service.getReview(id);
		request.setAttribute("review", review);
		request.getRequestDispatcher("/WEB-INF/review/updateform.jsp").forward(request, response);
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Review review = service.getReview(id);
		
		service.removeReview(id);
		response.sendRedirect("video?action=videoDetail&videoId=" + review.getVideoId());
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("review", service.getReview(id));
		request.getRequestDispatcher("/WEB-INF/review/detail.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer videoId = Integer.parseInt(request.getParameter("videoId"));
		request.setAttribute("list", service.getReviewListOfVideo(videoId));
		request.getRequestDispatcher("/WEB-INF/review/list.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer videoId = Integer.parseInt(request.getParameter("videoId"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		Review review = new Review(videoId, title, writer, content);
		
		service.writeReview(review);
		
		response.sendRedirect("video?action=videoDetail&videoId=" + videoId);
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer videoId = Integer.parseInt(request.getParameter("videoId"));
		request.setAttribute("videoId", videoId);
		request.getRequestDispatcher("/WEB-INF/review/writeform.jsp").forward(request, response);
	}
	
	private void doLike(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		service.likeReview(id);
	}
	
	private void doDislike(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		service.dislikeReview(id);
	}
}
