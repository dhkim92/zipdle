package basket.service;

import java.util.List;

import basket.dto.Basket;

public interface BasketService {
	
	//구매자 아이디별 구매목록 조회
		public List selectAll(Basket basket);

		//리스트 수량 수정
		public boolean updateamount(Basket basket);
		
		//리스트 선택 삭제
		public boolean deletelist(String checked);
		
		//구매후 리스트 all 삭제
		public boolean deletepersonserlist(Basket basket);

}
