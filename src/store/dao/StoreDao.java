package store.dao;

import java.util.List;

import basket.dto.Basket;
import store.dto.Store;
import util.Paging;

public interface StoreDao {
	
	// store 테이블 전체 조회
	public List<Store> selectAll();
	
	/*paging*/
		// 총 게시글 수 조회
		public int selectCntAll();

		//페이징 리스트 조회
		public List selectPagingList(Paging paging);
		
		//페이징 인덱스 조회
		public int selectindexCntAll(Store store);
		
		//페이징 인덱스 리스트 조회
		public List selectPagingindexList(Paging paging);
	/*paging end*/
		
		
	// 상품 세부 조회
	public Store selectItemByStoreno(Store store);
	

	//장바구니 리스트에 상품추가
	public boolean insertbasket(Basket basket);
	
	public boolean Delete(String checked);
	
	public boolean save(Store store);
	
}
