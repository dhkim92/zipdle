package basket.service;

import java.util.List;

import basket.dao.BasketDao;
import basket.dao.BasketDaoImpl;
import basket.dto.Basket;

public class BasketServiceImpl implements BasketService{

	private BasketDao basketDao = new BasketDaoImpl();
	
	@Override
	public List selectAll(Basket basket) {
		return basketDao.selectAll(basket);
	}

	@Override
	public boolean updateamount(Basket basket) {
		return basketDao.updateamount(basket);
	}

	@Override
	public boolean deletelist(String checked) {
		return basketDao.deletelist(checked );
	}

	@Override
	public boolean deletepersonserlist(Basket basket) {
		return basketDao.deletepersonserlist(basket);
	}

}
