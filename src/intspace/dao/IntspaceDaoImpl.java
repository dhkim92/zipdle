package intspace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import intspace.dto.Intspace;
import store.dto.Store;
import util.DBConn;
import util.Paging;

public class IntspaceDaoImpl implements IntspaceDao {

	private Connection conn = DBConn.getConnection();

	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List SelectAll() {
		Intspace dto = new Intspace();
		List<Intspace> intspaceList = new ArrayList<>();
		String sql = "SELECT * FROM intspace";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto.setIntspaceno(rs.getInt("intspaceno"));
				dto.setUserid(rs.getString("userid"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setHashtag(rs.getString("hashtag"));
				dto.setCounter(rs.getInt("viewCounter"));
				dto.setImgpath(rs.getString("imgpath"));

				intspaceList.add(dto);
			}

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@intspace selectAll() fail@@");
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@intspace selectAll().close fail@@");
				return null;
			}
		}
		return intspaceList;
	}

	@Override
	public int selectCntAll() {
		String sql = "SELECT count(*) FROM intspace";

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
	public List selectPagingList(Paging paging) {
		String sql = "SELECT * FROM (" + "    SELECT rownum rnum, I.* FROM (" + "        SELECT * FROM intspace"
				+ "        ORDER BY intspaceno DESC" + "    ) I" + "    ORDER BY rnum" + " )"
				+ " WHERE rnum BETWEEN ? AND ?";

		List<Intspace> IntspaceList = new ArrayList<>();
		Intspace intspace = null;
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			// ResultSet 반환
			rs = ps.executeQuery();

			while (rs.next()) {
				intspace = new Intspace();

				intspace.setIntspaceno(rs.getInt("intspaceno"));
				intspace.setUserid(rs.getString("userid"));
				intspace.setTitle(rs.getString("title"));
				intspace.setContent(rs.getString("content"));
				intspace.setHashtag(rs.getString("hashtag"));
				intspace.setCounter(rs.getInt("viewcounter"));
				intspace.setImgpath(rs.getString("imgpath"));

				// 결과 List
				IntspaceList.add(intspace);

			}
//		System.out.println("stList"+StoreList);

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

		return IntspaceList;
	}

	@Override
	public int selectindexCntAll(Intspace intspace) {

		String sql = "SELECT count(*) FROM intspace WHERE hashtag LIKE '%'||?||'%'";

		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, intspace.getHashtag());

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
	public List selectPagingindexList(Paging paging) {

//		System.out.println(paging);

		String sql = "SELECT * FROM (" + "    SELECT rownum rnum, I.* FROM (" + "        SELECT * FROM intspace"
				+ "          WHERE hashtag LIKE '%'||?||'%'" + "        ORDER BY intspaceno DESC" + "    ) I"
				+ "    ORDER BY rnum" + " )" + " WHERE rnum BETWEEN ? AND ?";

		// 결과 List
		List<Intspace> intspaceIndexList = new ArrayList<Intspace>();

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());

			rs = ps.executeQuery();

			while (rs.next()) {
				Intspace intspace = new Intspace();

				intspace.setIntspaceno(rs.getInt("intspaceno"));
				intspace.setUserid(rs.getString("userid"));
				intspace.setTitle(rs.getString("title"));
				intspace.setContent(rs.getString("content"));
				intspace.setHashtag(rs.getString("hashtag"));
				intspace.setCounter(rs.getInt("viewcounter"));
				intspace.setImgpath(rs.getString("imgpath"));

				intspaceIndexList.add(intspace);

			}
//			System.out.println("intIdxList"+intspaceIndexList);
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

		return intspaceIndexList;
	}

	@Override
	public Intspace selectTableByintspaceno(Intspace intspace) {
		Intspace dto = new Intspace();

		String sql = "SELECT * FROM intspace WHERE intspaceno=?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, intspace.getIntspaceno());

			rs = ps.executeQuery();

			rs.next();

			dto.setIntspaceno(rs.getInt("intspaceno"));
			dto.setUserid(rs.getString("userid"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setHashtag(rs.getString("hashtag"));
			dto.setCounter(rs.getInt("viewcounter"));
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
	public boolean save(Intspace intspace) {
		String sql = "INSERT INTO intspace ( intspaceno,title, userid, content, hashtag, viewcounter , imgpath) "
				+ " VALUES(intspace_seq.nextval, ?,?,?,?,'0',?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, intspace.getTitle());
			ps.setString(2, intspace.getUserid());
			ps.setString(3, intspace.getContent());
			ps.setString(4, intspace.getHashtag());
			ps.setString(5, intspace.getImgpath());

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

	@Override
	public List top3() {
		List<Intspace> top3 = new ArrayList<Intspace>();

		String sql = "SELECT * FROM (   SELECT rownum rnum, T.* FROM ( SELECT * FROM intspace ORDER BY viewcounter DESC )T ORDER BY rnum ) WHERE rnum BETWEEN 1 AND 3";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				Intspace intspace = new Intspace();

				intspace.setIntspaceno(rs.getInt("intspaceno"));
				intspace.setUserid(rs.getString("userid"));
				intspace.setTitle(rs.getString("title"));
				intspace.setContent(rs.getString("content"));
				intspace.setHashtag(rs.getString("hashtag"));
				intspace.setCounter(rs.getInt("viewcounter"));
				intspace.setImgpath(rs.getString("imgpath"));
				
				top3.add(intspace);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("@@top3 fail@@");
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@top3 close fail@@");
			}
		}
		return top3;

	}

	@Override
	public boolean viewCount(int view, int intspaceno) {
		String sql = "UPDATE intspace SET viewcounter=? WHERE intspaceno=? ";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, view);
			ps.setInt(2, intspaceno);
			ps.executeQuery();

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@viewCount fail@@");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@viewCount close fail@@");
			}
		}
		return true;
	}

	@Override
	public int gradecheck(String userid) {
		String sql = "SELECT usergrade FROM zipuser WHERE userid=?";
		int grade = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);

			rs = ps.executeQuery();
			rs.next();

			grade = rs.getInt("usergrade");

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@gradecheck fail@@");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@gradecheck close fail@@");
			}
		}

		return grade;
	}

	@Override
	public boolean delete(int intspaceno) {
		System.out.println(intspaceno);
		String sql = "DELETE FROM intspace WHERE intspaceno IN ( " + intspaceno + ")";

		try {
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@ deletelist(int intspaceno) fail@@");
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@ deletelist(int intspaceno) close fail@@");
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean updatesave(Intspace intspace) {
		String sql = "UPDATE intspace SET title = ?,content = ? ,hashtag = ?,imgpath = ? WHERE intspaceno = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, intspace.getTitle());
			ps.setString(2, intspace.getContent());
			ps.setString(3, intspace.getHashtag());
			ps.setString(4, intspace.getImgpath());
			ps.setInt(5, intspace.getIntspaceno());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.getMessage();
			System.out.println("@@updatesave(Intspace intspace) fail@@");
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@@@updatesave(Intspace intspace)) close fail@@");
				return false;
			}
		}

		return true;
	}

	@Override
	public Intspace top() {
		
		Intspace intspace = new Intspace();
		
		String sql = "SELECT * FROM (   SELECT rownum rnum, T.* FROM ( SELECT * FROM intspace ORDER BY viewcounter DESC )T ORDER BY rnum ) WHERE rnum BETWEEN 1 AND 1";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			rs.next();

				intspace.setIntspaceno(rs.getInt("intspaceno"));
				intspace.setUserid(rs.getString("userid"));
				intspace.setTitle(rs.getString("title"));
				intspace.setContent(rs.getString("content"));
				intspace.setHashtag(rs.getString("hashtag"));
				intspace.setCounter(rs.getInt("viewcounter"));
				intspace.setImgpath(rs.getString("imgpath"));
				

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("@@top3 fail@@");
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("@@top3 close fail@@");
			}
		}
		return intspace;
	}

}