package com.example.TimeCommunityVaadin;

import java.time.LocalDateTime;

public class Comment {

	private String text;
	private LocalDateTime time;
	private String writer;
	
	public Comment(String text, LocalDateTime time){//, String writer){
		this.text = text;
		this.time = time;
		//this.writer = writer;
		this.writer = "default_user";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
