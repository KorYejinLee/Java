package com.hrd.app;

public class BoardVO {
	private int seq;
	private int cnt;
	private String title;
	private String writer;
	private String content;
	
    public BoardVO() {
    }
	
	public BoardVO(int seq, String title, String writer, String content, int cnt) {
		super();
		this.seq = seq;
		this.cnt = cnt;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
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

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", cnt=" + cnt + ", title=" + title + ", writer=" + writer + ", content="
				+ content + "]";
	}
	
}