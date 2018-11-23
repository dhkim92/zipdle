package qna.dto;

import java.sql.Date;

public class QnaDto {
	private int idx; // 글 번호
	private String id; // 작성자 아이디
	private String content; // 글 내용
	private String hashTag; // 해시태그
	private Date wDate; // 작성 날짜
	
	@Override
	public String toString() {  
		return "Qna [idx=" + idx
				+ ", id=" + id
				+ ", content=" + content
				+ ", hashTag=" + hashTag
				+ ", wDate=" + wDate 
				+ "]";
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	public Date getwDate() {
		return wDate;
	}
	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}
	
	
}
