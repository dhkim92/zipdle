package interior.dto;

import java.util.Date;

public class IntList {
	private int ListNo; // 견적번호
	private String writer; // 작성자
	private String intSpace; // 주거공간
	private String intName; // 견적 명
	private String imgPath; // 이미지 경로
	private int intPrice; // 견적희망금액
	private String content;// 게시글 내용
	private int hit; // 조회수
	private Date writtenDate; // 작성일자
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public int getListNo() {
		return ListNo;
	}
	public void setListNo(int listNo) {
		ListNo = listNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIntSpace() {
		return intSpace;
	}
	public void setIntSpace(String intSpace) {
		this.intSpace = intSpace;
	}
	public String getIntName() {
		return intName;
	}
	public void setIntName(String intName) {
		this.intName = intName;
	}
	
	public int getIntPrice() {
		return intPrice;
	}
	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}
	public Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	@Override
	public String toString() {
		return "IntList [ListNo=" + ListNo + ", writer=" + writer + ", intSpace=" + intSpace + ", intName=" + intName
				+ ", imgPath=" + imgPath + ", intPrice=" + intPrice + ", content=" + content + ", hit=" + hit
				+ ", writtenDate=" + writtenDate + "]";
	}
}
