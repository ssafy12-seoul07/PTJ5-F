package com.ssafy.video.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.review.model.dto.Review;
import com.ssafy.review.model.service.ReviewService;
import com.ssafy.review.model.service.ReviewServiceImpl;
import com.ssafy.video.model.dto.Video;
import com.ssafy.video.model.service.VideoService;
import com.ssafy.video.model.service.VideoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video")
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private VideoService videoService = VideoServiceImpl.getInstance();
	private ReviewService reviewService = ReviewServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "getList":
			doGetList(request, response);
			break;
		case "videoDetail":
			doVideoDetail(request, response);
			break;
		default:
			break;
		}

	}

	private void doVideoDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer videoId = Integer.parseInt(request.getParameter("videoId"));
		
		List<Review> reviewList = reviewService.getReviewListOfVideo(videoId);
		Video video = videoService.getVideo(videoId);
		
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("video", video);
		request.getRequestDispatcher("/WEB-INF/video/detail.jsp").forward(request, response);

	}

	private void doGetList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> videoList = videoService.getList();
		request.setAttribute("videoList", videoList);
		request.getRequestDispatcher("/WEB-INF/video/videolist.jsp").forward(request, response);
	}

}
