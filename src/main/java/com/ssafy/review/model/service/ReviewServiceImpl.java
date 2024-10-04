package com.ssafy.review.model.service;

import java.util.List;

import com.ssafy.review.model.dto.Review;
import com.ssafy.review.model.repository.ReviewDao;
import com.ssafy.review.model.repository.ReviewDaoImpl;

//싱글턴으로 관리
public class ReviewServiceImpl implements ReviewService {

	private static ReviewService service = new ReviewServiceImpl();
	
	private ReviewDao dao = ReviewDaoImpl.getInstance();

	private ReviewServiceImpl() {
	}

	public static ReviewService getInstance() {
		return service;
	}

	public List<Review> getReviewListOfVideo(int videoId) {
		return dao.selectAllByVideoId(videoId);
	}

	public Review getReview(int id) {
		return dao.selectOne(id);
	}

	public void writeReview(Review review) {
		dao.insertReview(review);
	}

	public void modifyReview(Review review) {
		dao.updateReview(review);
	}

	public void removeReview(int id) {
		dao.deleteReview(id);
	}

	public void likeReview(int id) {
		Review review = dao.selectOne(id);
		
		review.setLikeCnt(review.getLikeCnt() + 1);
		
		dao.updateReview(review);
	}

	
	public void dislikeReview(int id) {
		Review review = dao.selectOne(id);
		
		review.setDislikeCnt(review.getDislikeCnt() + 1);
		
		dao.updateReview(review);
	}

}
