package basket.dto;

public class Basket {
	
	private String userid;
	private int basketno;
	private String basketname;
	private int basketprice;
	private int basketamount;
	private String imgpath;
	
	@Override
	public String toString() {
		return "Basket [userid=" + userid + ", basketno=" + basketno + ", basketname=" + basketname + ", basketprice="
				+ basketprice + ", basketamount=" + basketamount + ", imgpath=" + imgpath + "]";
	}
	
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getBasketno() {
		return basketno;
	}
	public void setBasketno(int basketno) {
		this.basketno = basketno;
	}
	public String getBasketname() {
		return basketname;
	}
	public void setBasketname(String basketname) {
		this.basketname = basketname;
	}
	public int getBasketprice() {
		return basketprice;
	}
	public void setBasketprice(int basketprice) {
		this.basketprice = basketprice;
	}
	public int getBasketamount() {
		return basketamount;
	}
	public void setBasketamount(int basketamount) {
		this.basketamount = basketamount;
	}
	
	

}
