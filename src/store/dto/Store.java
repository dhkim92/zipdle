package store.dto;

public class Store {
	private int itemno;
	private String itemcategory;
	private String itemname;
	private String iteminfo;
	private int itemprice;
	private String hashtag;
	private String imgpath;
	
	@Override
	public String toString() {
		return "Store [itemno=" + itemno + ", itemcategory=" + itemcategory + ", itemname=" + itemname + ", iteminfo="
				+ iteminfo + ", itemprice=" + itemprice + ", hashtag=" + hashtag + ", imgpath=" + imgpath + "]";
	}
	
	
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getItemcategory() {
		return itemcategory;
	}
	public void setItemcategory(String itemcategory) {
		this.itemcategory = itemcategory;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getIteminfo() {
		return iteminfo;
	}
	public void setIteminfo(String iteminfo) {
		this.iteminfo = iteminfo;
	}
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
	

}
