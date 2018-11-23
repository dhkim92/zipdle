package interior.dto;

public class IntEdit {
	private int editNo; // 에디터 번호 (seq)
	private int resiNo; // 사업자등록번호
	private String name; // 상호명
	private String manager; // 대표자
	private String content; // 에디터 소개 글
	private String phonenum; // 연락처
	private String address; // 주소
	private String imgPath; // 이미지 경로
	private int grade;
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getEditNo() {
		return editNo;
	}
	public void setEditNo(int editNo) {
		this.editNo = editNo;
	}
	
	public int getResiNo() {
		return resiNo;
	}
	public void setResiNo(int resiNo) {
		this.resiNo = resiNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "IntEdit [editNo=" + editNo + ", resiNo=" + resiNo + ", name=" + name + ", manager=" + manager
				+ ", content=" + content + ", phonenum=" + phonenum + ", address=" + address + ", imgPath=" + imgPath
				+ "]";
	}
	
}
