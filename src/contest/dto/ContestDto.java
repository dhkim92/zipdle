package contest.dto;

import java.sql.Date;

public class ContestDto {
	private int idx; // 글 번호
	private String id; // 작성자 아이디
	private String content; // 글 내용
	private String hashTag; // 해시태그
	private Date wDate; // 작성날짜 
	private String filePath; // 사진 경로 
	
	
	@Override
	public String toString() {
		return "ContestDto [idx=" + idx + ", id=" + id + ", content=" + content + ", hashTag=" + hashTag + ", wDate="
				+ wDate + ", filePath=" + filePath + "]";
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
