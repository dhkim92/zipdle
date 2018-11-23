package reform.dto;

import java.sql.Date;

public class CommentDto {
	
	private int commentIdx;		// 댓글 고유번호, PK
	private int boardIdx;		// 댓글이 달린 게시글의 고유 번호
	private String commentId; 	// 댓글 작성자 아이디
	private String commentContent; // 댓글 내용
	private Date commentwDate; // 댓글 작성날짜	
	private String boardName; // 게시판 이름 
	
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getCommentIdx() {
		return commentIdx;
	}
	public void setCommentIdx(int commentIdx) {
		this.commentIdx = commentIdx;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentwDate() {
		return commentwDate;
	}
	public void setCommentwDate(Date commentwDate) {
		this.commentwDate = commentwDate;
	}
	@Override
	public String toString() {
		return "CommentDto [commentIdx=" + commentIdx + ", boardIdx=" + boardIdx + ", commentId=" + commentId
				+ ", commentContent=" + commentContent + ", commentwDate=" + commentwDate + ", boardName=" + boardName
				+ "]";
	}
	
}

