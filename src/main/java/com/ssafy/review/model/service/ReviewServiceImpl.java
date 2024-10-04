package com.ssafy.review.model.service;

import java.util.List;

import com.ssafy.review.model.dto.Review;
import com.ssafy.review.model.repository.ReviewRepository;
import com.ssafy.review.model.repository.ReviewRepositoryImpl;

//싱글턴으로 관리
public class ReviewServiceImpl implements ReviewService {

	private static ReviewService service = new ReviewServiceImpl();
	private ReviewRepository repo = ReviewRepositoryImpl.getInstance();

	private ReviewServiceImpl() {
	}

	public static ReviewService getInstance() {
		return service;
	}

	public List<Review> getReviewListOfVideo(int videoId) {
		return repo.selectAllByVideoId(videoId);
	}

	public Review getReview(int id) {
		return repo.selectOne(id);
	}

	public void writeReview(Review review) {
		repo.insertReview(review);
	}

	public void modifyReview(Review review) {
		repo.updateReview(review);
	}

	public void removeReview(int id) {
		repo.deleteReview(id);
	}

	public void likeReview(int id) {
		Review review = repo.selectOne(id);
		
		review.setLikeCnt(review.getLikeCnt() + 1);
		
		repo.updateReview(review);
	}

	
	public void dislikeReview(int id) {
		Review review = repo.selectOne(id);
		
		review.setDislikeCnt(review.getDislikeCnt() + 1);
		
		repo.updateReview(review);
	}

}
