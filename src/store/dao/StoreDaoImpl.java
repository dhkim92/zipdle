
package store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basket.dto.Basket;
import store.dto.Store;
import util.DBConn;
import util.Paging;

public class StoreDaoImpl implements StoreDao {

	// DB 연결 객체
	private Connection conn = DBConn.getConnection();

	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<Store> selectAll() {

		// 전체조회 쿼리
		String sql = "SELECT * FROM store ORDER BY itemno";

		// 결과 List
		List<Store> storeList = new ArrayList<Store>();

		try {
			// ps 생성
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Store dto = new Store();

				dto.setItemno(rs.getInt("itemno"));
				dto.setItemname(rs.getString("itemname"));
				dto.setIteminfo(rs.getString("iteminfo"));
				dto.setItemprice(rs.getInt("itemprice"));
				dto.setImgpath(rs.getString("imgpath"));

				// 결과 List
				storeList.add(dto);

			}
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@store selectAll fail@@");
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@store selectAll close fail@@");
				return null;
			}
		}

		return storeList;
	}

	@Override
	public int selectCntAll() {
		String sql = "SELECT count(*) FROM store";

		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@selectCount fail@@");
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@selectCount close fail@@");
			}
		}

		return cnt;
	}

	@Override
	public int selectindexCntAll(Store store) {

		String sql = "SELECT count(*) FROM store WHERE itemhashtag LIKE '%'||?||'%'";

		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, store.getHashtag());

			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@selectCount fail@@");
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@selectCount close fail@@");
			}
		}

		return cnt;
	}

	@Override
	public List selectPagingList(Paging paging) {
		String sql = "SELECT * FROM (" + "    SELECT rownum rnum, S.* FROM (" + "        SELECT * FROM store"
				+ "        ORDER BY itemNo DESC" + "    ) S" + "    ORDER BY rnum" + " )"
				+ " WHERE rnum BETWEEN ? AND ?";

		List<Store> StoreList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			// ResultSet 반환
			rs = ps.executeQuery();

			while (rs.next()) {
				Store store = new Store();

				store.setItemno(rs.getInt("itemno"));
				store.setItemname(rs.getString("itemname"));
				store.setIteminfo(rs.getString("iteminfo"));
				store.setHashtag(rs.getString("itemhashtag"));
				store.setItemprice(rs.getInt("itemprice"));
				store.setImgpath(rs.getString("imgpath"));

				// 결과 List
				StoreList.add(store);

			}

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@selectPagingList fail@@");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@selectPagingList close fail@@");
			}

		}

		return StoreList;
	}

	@Override
	public List selectPagingindexList(Paging paging) {

		String sql = "SELECT * FROM (" + "    SELECT rownum rnum, S.* FROM (" + "        SELECT * FROM store"
				+ "          WHERE itemhashtag LIKE '%'||?||'%'" + "        ORDER BY itemNo DESC" + "    ) S"
				+ "    ORDER BY rnum" + " )" + " WHERE rnum BETWEEN ? AND ?";

		// 결과 List
		List<Store> storeindexList = new ArrayList<Store>();

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());

			rs = ps.executeQuery();

			while (rs.next()) {
				Store dto = new Store();

				dto.setItemno(rs.getInt("itemno"));
				dto.setItemname(rs.getString("itemname"));
				dto.setIteminfo(rs.getString("iteminfo"));
				dto.setItemprice(rs.getInt("itemprice"));
				dto.setImgpath(rs.getString("imgpath"));
				dto.setHashtag(rs.getString("itemhashtag"));

				storeindexList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("@@selectPagingindexList fail@@");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@selectPagingindexList close fail@@");
			}

		}

		return storeindexList;
	}

	@Override
	public Store selectItemByStoreno(Store store) {
		Store dto = new Store();

		String sql = "SELECT * FROM store WHERE itemno=?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, store.getItemno());

			rs = ps.executeQuery();

			rs.next();

			dto.setItemno(rs.getInt("itemno"));
			dto.setItemname(rs.getString("itemname"));
			dto.setIteminfo(rs.getString("iteminfo"));
			dto.setItemprice(rs.getInt("itemprice"));
			dto.setHashtag(rs.getString("itemhashtag"));
			dto.setImgpath(rs.getString("imgpath"));

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("@@selectItemBystoreno fail@@");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@selectItemBystoreno close fail@@");
			}
		}
		return dto;
	}

	@Override
	public boolean insertbasket(Basket basket) {

		String sql = "INSERT INTO basket( basketno, userid, basketitemname, basketprice, basketamount, imgpath) VALUES (basket_seq.nextval,?,?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, basket.getUserid());/* userid 삽입 */
			ps.setString(2, basket.getBasketname());
			ps.setInt(3, basket.getBasketprice());
			ps.setInt(4, basket.getBasketamount());/* amount 삽입 */
			ps.setString(5, basket.getImgpath());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@insertbasket(Store store) fail@@");
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {

				e.getMessage();
				System.out.println("@@insertbasket(Store store) close fail@@");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean Delete(String checked) {
		String sql = "DELETE FROM store WHERE itemno IN ( " + checked + ")";

		try {
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@Basket deletelist(int basketNo) fail@@");
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@Basket deletelist(int basketNo) close fail@@");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean save(Store store) {
		String sql = "INSERT INTO store ( itemno, itemname, iteminfo, itemprice, itemhashtag, imgpath) "
				+ " VALUES(item_seq.nextval, ?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, store.getItemname());
			ps.setString(2, store.getIteminfo());
			ps.setInt(3, store.getItemprice());
			ps.setString(4, store.getHashtag());
			ps.setString(5, store.getImgpath());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("@@intspacesave fail@@");
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("@@intspaceSave.close fail@@");
			}
		}
		return true;
	}

}
