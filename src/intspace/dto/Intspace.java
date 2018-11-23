package intspace.dto;

public class Intspace {
	private int intspaceno;
	private String userid;
	private String title;
	private String content;
	private String hashtag;
	private int counter;
	private String imgpath;

	@Override
	public String toString() {
		return "Intspace [intspaceno=" + intspaceno + ", userid=" + userid + ", title=" + title + ", content=" + content
				+ ", hashtag=" + hashtag + ", counter=" + counter + ", imgpath=" + imgpath + "]";
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public int getIntspaceno() {
		return intspaceno;
	}

	public void setIntspaceno(int intspaceno) {
		this.intspaceno = intspaceno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
	
}
