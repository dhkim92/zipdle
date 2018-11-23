package store.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.dto.Store;
import util.Paging;

public interface StoreService {

	// item 리스트 조회
	public List<Store> getList();
	
	// 총 item 수
	public int getTotal();
	
	// 페이징 리스트 조회
	public List getPagingList(Paging paging);
	
	// index item 수
	public int getidxcount(Store store);
	
	//index 페이징 리스트 조회
	public List getPagingidxList(Paging paging);
	
	// item 상세 조회
	public Store view(Store store);
	
	// basket아이템 담기
	public boolean insertbasket(Store store , String userid , int itemamount);
	
	public boolean Delete(String checked);
	
	public Store getitemdata(HttpServletRequest request, HttpServletResponse response );
	
	public boolean save(Store store);
	
	
	
}
