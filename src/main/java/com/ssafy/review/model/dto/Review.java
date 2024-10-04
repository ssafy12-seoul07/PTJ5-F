package com.ssafy.review.model.dto;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static int no = 1; //클래스변수
	private int id;
	private int videoId;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int likeCnt;
	private int dislikeCnt;

	public Review() {
	}

	public Review(int videoId, String title,  String writer, String content) {
		this.id = no++;
		this.videoId = videoId;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = new Date().toString();
		this.likeCnt = 0;
		this.dislikeCnt = 0;
	}

	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		Review.no = no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getDislikeCnt() {
		return dislikeCnt;
	}

	public void setDislikeCnt(int dislikeCnt) {
		this.dislikeCnt = dislikeCnt;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", videoId=" + videoId + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", regDate=" + regDate + ", likeCnt=" + likeCnt + ", dislikeCnt=" + dislikeCnt + "]";
	}


}
