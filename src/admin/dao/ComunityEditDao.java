package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import reform.dto.ReformDto;
import util.DBConn;

public class ComunityEditDao {

	private Connection conn = DBConn.getConnection();
	
	private Statement st; 
	private PreparedStatement ps;
	private ResultSet rs;  
	
	public void deleteReform(String check) {
		String sql = "delete from COMReform"
				+ " where idx IN("+ check +")";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();
			
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	}
	public void deleteContest(String check) {
		String sql = "delete from COMContest"
				+ " where idx IN("+ check +")";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();
			
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	}
}
