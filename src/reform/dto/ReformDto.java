package reform.dto;

import java.sql.Date;

public class ReformDto {
	private int idx; // 글 번호
	private String id; // 작성자 아이디
	private String title; // 글 제목
	private String content; // 글 내용
	private int recommend; 	// 추천수
	private String filePath; // 사진 경로
	private Date wDate; // 작성 날짜 
 
	public String getFilePath() {
		return filePath; 
	}
	 
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() { 
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getwDate() {
		return wDate;
	}
	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}
	@Override
	public String toString() {
		return "ReformDto [idx=" + idx + ", id=" + id + ", title=" + title + ", content=" + content + ", recommend="
				+ recommend + ", filePath=" + filePath + ", wDate=" + wDate + "]";
	}
	 
	
}
