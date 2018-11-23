package login.dto;

import java.util.Date;

public class UserDto {

	private int userNo;			// 유저 번호
	private String userId;   	// 아이디
	private String userPw; 	 	// 비밀번호
	private String userRePw;	// 비밀번호 재입력
	private String userName; 	// 이름
	private Date userBirth;	 	// 생년월일
	private String userEmail;	// 이메일
	private String userPhone;	// 연락처
	private String userAddress;	// 주소
	private int userGrade;		// 등급 부여 - 회원가입시 1 = 일반회원
	private String profileImg;	// 프로필 이미지 경로
	


	@Override
	public String toString() {
		return "UserDto [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userRePw=" + userRePw
				+ ", userName=" + userName + ", userBirth=" + userBirth + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userAddress=" + userAddress + ", userGrade=" + userGrade + ", profileImg=" + profileImg
				+ "]";
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserRePw() {
		return userRePw;
	}


	public void setUserRePw(String userRePw) {
		this.userRePw = userRePw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getUserBirth() {
		return userBirth;
	}


	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	public int getUserGrade() {
		return userGrade;
	}
	
	
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}


	public String getProfileImg() {
		return profileImg;
	}


	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
}
