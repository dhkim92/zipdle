package basket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basket.dto.Basket;
import util.DBConn;

public class BasketDaoImpl implements BasketDao {
	
	private Connection conn = DBConn.getConnection();
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List selectAll(Basket basket) {

		
		List<Basket> basketList = new ArrayList<Basket>();
		
		String sql = "SELECT * FROM basket WHERE userid=? ORDER BY basketno";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, basket.getUserid());

			rs = ps.executeQuery();
				
			while(rs.next()) {
				Basket dto = new Basket();
				
				dto.setUserid(rs.getString("userid"));
				dto.setBasketno(rs.getInt("basketno"));
				dto.setBasketname(rs.getString("basketitemname"));
				dto.setBasketamount(rs.getInt("basketamount"));
				dto.setBasketprice(rs.getInt("basketprice"));
				dto.setImgpath(rs.getString("imgpath"));
				
				basketList.add(dto);

			}

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@Basket selectAll(userId) fail@@");
			return null;
		}finally {
				try {
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					e.getMessage();
					System.out.println("@@Basket selectAll(userId) close fail@@");
					return null;
				}
		}
		
		
		return basketList;
	}

	@Override
	public boolean updateamount(Basket basket) {// 수량수정

		String sql = "UPDATE Basket SET basketamount=? WHERE userid=? AND basketno=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, basket.getBasketamount());
			ps.setString(2, basket.getUserid());
			ps.setInt(3, basket.getBasketno());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@Basket updateamount(Basket basket) fail@@");
			return false;
		}finally {
				try {
					if(ps!=null) ps.close();
				} catch (SQLException e) {
					e.getMessage();
					System.out.println("@@Basket updateamount(Basket basket) close fail@@");
					return false;
				}
		}
		
		
		return true;
	}

	@Override
	public boolean deletelist(String checked) {//낱개 장바구니 삭제
		String sql = "DELETE FROM basket WHERE basketno IN ( "+checked+")";
		System.out.println(checked);
		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@Basket deletelist(int basketNo) fail@@");
			return false;
		}finally {
				try {
					if(ps != null) ps.close();
				} catch (SQLException e) {
					e.getMessage();
					System.out.println("@@Basket deletelist(int basketNo) close fail@@");
					return false;
				}
		}
		
		return true;
	}

	@Override
	public boolean deletepersonserlist(Basket basket) {//구매 완료시
		String sql = "DELETE FROM basket WHERE( userid=?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, basket.getUserid());
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@deletepersonserlist(String Userid) fail@@");
			return false;
			
		}finally {
				try {
					if(ps != null) ps.close();
				} catch (SQLException e) {
					e.getMessage();
					System.out.println("@@deletepersonserlist(String Userid) close fail@@");
					return false;
				}
		}
		
		return true;
	}


}
