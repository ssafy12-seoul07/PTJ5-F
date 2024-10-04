package com.ssafy.video.model.dto;

public class Video{
	private int id;
	private String title;
	private String part;
	private String channelName;
	private String url;
	
	public Video() {
	}
	
	public Video(int id, String title, String part, String channelName, String url) {
		super();
		this.id = id;
		this.title = title;
		this.part = part;
		this.channelName = channelName;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", part=" + part + ", channelName=" + channelName + ", url="
				+ url + "]";
	}
	
}