package interior.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import interior.dto.IntEdit;
import login.dto.UserDto;
import util.DBConn;
import util.Paging;
import util.PagingEdit;

public class IntEditDaoImpl implements IntEditDao{
	
	private Connection conn = DBConn.getConnection();
	
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<IntEdit> selectPagingEditList(PagingEdit paging) {
		String sql = "select * from ("
				+" select rownum rnum, B.* from ("
				+" select * from intEdit"
					    + " order by editNo desc"
					+ ") B"

					+ " order by rnum"
					+")"
					+ " where rnum between ? and ? and grade=3";
		
		List<IntEdit> list = new ArrayList<>();
		IntEdit dto =null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new IntEdit();
				
				dto.setEditNo(rs.getInt("editNo"));
				dto.setResiNo(rs.getInt("resiNo"));
				dto.setName(rs.getString("name"));
				dto.setManager(rs.getString("manager"));
				dto.setContent(rs.getString("content"));
				dto.setPhonenum(rs.getString("phonenum"));
				dto.setAddress(rs.getString("address"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setGrade(rs.getInt("grade"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(1);
			return null;
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(2);
			}
		}
		return list;
	}
	
	@Override
	public List<IntEdit> selectPagingEditorList(Paging paging) {
		String sql = "select * from ("
				+" select rownum rnum, B.* from ("
				+" select * from intEdit"
					    + " order by editNo desc"
					+ ") B"

					+ " order by rnum"
					+")"
					+ " where rnum between ? and ? and grade=0";
		
		List<IntEdit> list = new ArrayList<>();
		IntEdit dto =null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new IntEdit();
				
				dto.setEditNo(rs.getInt("editNo"));
				dto.setResiNo(rs.getInt("resiNo"));
				dto.setName(rs.getString("name"));
				dto.setManager(rs.getString("manager"));
				dto.setContent(rs.getString("content"));
				dto.setPhonenum(rs.getString("phonenum"));
				dto.setAddress(rs.getString("address"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setGrade(rs.getInt("grade"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(1);
			return null;
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(2);
			}
		}
		return list;
	}
	
	
	@Override
	public List<IntEdit> selectAll() {
		
		List<IntEdit> list = new ArrayList<>();
		
		String sql ="select * from IntEdit order by editNo desc";
		IntEdit dto =null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				dto = new IntEdit();
				
				dto.setEditNo(rs.getInt("editNo"));
				dto.setResiNo(rs.getInt("resiNo"));
				dto.setName(rs.getString("name"));
				dto.setManager(rs.getString("manager"));
				dto.setContent(rs.getString("content"));
				dto.setPhonenum(rs.getString("phonenum"));
				dto.setAddress(rs.getString("address"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setGrade(rs.getInt("grade"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("IntEdit selectAll fail...");
			return null;
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("IntEdit selectAll close fail...");
				return null;
			}
		}
		
		return list;
	}

	@Override
	public IntEdit selectAll(int EditNo) {
		

		IntEdit dto = new IntEdit();
		
		String sql ="select * from IntEdit where editNo=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, EditNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				dto.setEditNo(EditNo);
				dto.setResiNo(rs.getInt("resiNo"));
				dto.setName(rs.getString("name"));
				dto.setManager(rs.getString("manager"));
				dto.setContent(rs.getString("content"));
				dto.setPhonenum(rs.getString("phonenum"));
				dto.setAddress(rs.getString("address"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setGrade(rs.getInt("grade"));
			}
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("IntEdit selectAll(EditNo) fail...");
			return null;
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("IntEdit selectAll(EditNo) close fail...");
				return null;
			}
		}
		
		return dto;
	}

	@Override
	public List<IntEdit> selectByGrade(int grade) {
		
		List<IntEdit> list = new ArrayList<>();
		
		String sql ="select * from IntEdit where grade=?";
		
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, grade);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				IntEdit dto = new IntEdit();
				
				dto.setEditNo(rs.getInt("editNo"));
				dto.setResiNo(rs.getInt("resiNo"));
				dto.setName(rs.getString("name"));
				dto.setManager(rs.getString("manager"));
				dto.setContent(rs.getString("content"));
				dto.setPhonenum(rs.getString("phonenum"));
				dto.setAddress(rs.getString("address"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setGrade(rs.getInt("grade"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("IntEdit selectAll(category) fail...");
			return null;
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				
			} catch (SQLException e) {
				e.getMessage();
				System.out.println("IntEdit selectAll(category) close fail...");
				return null;
			}
		}
		
		return list;
	}
	
	@Override
	public boolean insertEdit(IntEdit IntEdit, UserDto userG) {
		
		
		String sql = "insert into IntEdit values("+userG.getUserNo()+",?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, IntEdit.getResiNo());
			ps.setString(2, IntEdit.getName());
			ps.setString(3, IntEdit.getManager());
			ps.setString(4, IntEdit.getContent());
			ps.setString(5, IntEdit.getPhonenum());
			ps.setString(6, IntEdit.getAddress());
			ps.setString(7, IntEdit.getImgPath());
			ps.setInt(8, IntEdit.getGrade());
			
			
			ps.executeQuery();
			
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("IntEdit insertEdit fail...");
			
			return false;
		
		} finally {
				try {
					if(ps!=null) ps.close();
					
				} catch (SQLException e) {
					e.getMessage();
					System.out.println("IntEdit insertEdit close fail...");
					
					return false;
				}
		}
		return true;
	}

	@Override
	public boolean updateEdit(IntEdit IntEdit) {

			String sql = "UPDATE IntEdit SET resiNo=?, manager=?, content=?, phonenum=?, address=?,imgPath=? grade=? where editNo=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, IntEdit.getResiNo());
			ps.setString(2, IntEdit.getManager() );
			ps.setString(3, IntEdit.getContent());
			ps.setString(4, IntEdit.getPhonenum());
			ps.setString(5, IntEdit.getAddress());
			ps.setString(6, IntEdit.getImgPath());
			ps.setInt(7, IntEdit.getGrade());
			ps.setInt(8, IntEdit.getEditNo());
			
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updateEdit fail...");
			return false;
		} finally {
			try {
				if(ps!=null)ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return true;
		
	}


	@Override
	public boolean deleteEdit(int resiNo) {
		
			String sql = "delete from IntEdit where resiNo=?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, resiNo);
				
				ps.executeQuery();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("deleteEdit fail...");
				return false;
				
			} finally {
				
				try {
					if(ps!=null)ps.close();
				} catch (SQLException e) {
					System.out.println("deleteEdit close fail...");
				}
			}
			
		return true;
	}
	
	@Override
	public boolean deleteEditByEditNo(int editNo) {
		
			String sql = "delete from IntEdit where editNo?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, editNo);
				
				ps.executeQuery();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("deleteEdit fail...");
				return false;
				
			} finally {
				
				try {
					if(ps!=null)ps.close();
				} catch (SQLException e) {
					System.out.println("deleteEdit close fail...");
				}
			}
			
		return true;
	}
	

	@Override
	public int selectCntAll() {
			String sql = "SELECT count(*) FROM IntEdit";
		
		int cnt = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	@Override
	public boolean deleteByChecked(String checked) {
		
		String sql = "DELETE FROM intEdit WHERE editNo IN ( "+checked+")";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("deleteByChecked fail...");
			return false;
		}finally {
				try {
					if(ps != null) ps.close();
				} catch (SQLException e) {
					e.getMessage();
					System.out.println("deleteByChecked close fail...");
					return false;
				}
		}
		
		return true;
	}

	@Override
	public boolean updateToChecked(String checked) {
		
			String sql = "UPDATE IntEdit SET grade=3 where editNo IN ("+checked+")";
			String sql2 = "Update zipuser set usergrade=3 where userNo In ("+checked+")";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updateEdit fail...");
			return false;
		} finally {
			try {
				if(ps!=null)ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		try {
				ps = conn.prepareStatement(sql2);
				ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updateEdit fail...");
			return false;
		} finally {
			try {
				if(ps!=null)ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return true;
		
	}
	
	@Override
	public List<IntEdit> selectPagingCompanyList(Paging paging) {
		String sql = "select * from ("
				+" select rownum rnum, B.* from ("
				+" select * from intEdit where grade=3"
					    + " order by editNo desc"
					+ ") B"

					+ " order by rnum"
					+")"
					+ " where rnum between ? and ?";
		
		List<IntEdit> list = new ArrayList<>();
		IntEdit dto =null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new IntEdit();
				
				dto.setEditNo(rs.getInt("editNo"));
				dto.setResiNo(rs.getInt("resiNo"));
				dto.setName(rs.getString("name"));
				dto.setManager(rs.getString("manager"));
				dto.setContent(rs.getString("content"));
				dto.setPhonenum(rs.getString("phonenum"));
				dto.setAddress(rs.getString("address"));
				dto.setImgPath(rs.getString("imgPath"));
				dto.setGrade(rs.getInt("grade"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(1);
			return null;
		} finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(2);
			}
		}
		return list;
	}
	

	

}
