package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import common.DBConnection;
import vo.MemberVo;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<MemberVo> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberVo> memberList = new ArrayList<>();
		try {
			conn = DBConnection.dbConn();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo(
						rs.getInt("id"), 
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getDate("dateAt"),
						rs.getTime("timeAt"));
				memberList.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null ) rs.close();}
			catch (SQLException e) {e.printStackTrace();}
			try { if(pstmt != null ) pstmt.close();}
			catch (SQLException e) {e.printStackTrace();}
			try { if(conn != null ) conn.close();}
			catch (SQLException e) {e.printStackTrace();}
		}
		return memberList;
	}
	
	@Override
	public boolean insert(MemberVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean isSuccess = false;
		
		try {
			conn = DBConnection.dbConn();
			String sql = "INSERT into member";
			sql += "(username, password, email, dateAt, timeAt) ";
			sql += "VALUES (?,?,?,curdate(),curtime())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			if(pstmt.executeUpdate() == 1) {
				isSuccess = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null ) pstmt.close();}
			catch (SQLException e) {e.printStackTrace();}
			try { if(conn != null ) conn.close();}
			catch (SQLException e) {e.printStackTrace();}
		}
		
		return isSuccess;
	}

	@Override
	public MemberVo selectOne(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo memberVo = null;
		
		try {
			conn = DBConnection.dbConn();
			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberVo = new MemberVo(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getDate("dateAt"),
						rs.getTime("timeAt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null ) rs.close();}
			catch (SQLException e) {e.printStackTrace();}
			try { if(pstmt != null ) pstmt.close();}
			catch (SQLException e) {e.printStackTrace();}
			try { if(conn != null ) conn.close();}
			catch (SQLException e) {e.printStackTrace();}
		}
		
		return memberVo;
	}

	@Override
	public boolean update(MemberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean isSuccess = false;
		
		try {
			conn = DBConnection.dbConn();
			String sql = "UPDATE member SET ";
			sql += "username = ?, email = ?, password = ? ";
			sql += "WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getUsername());
			pstmt.setString(2, memberVo.getEmail());
			pstmt.setString(3, memberVo.getPassword());
			pstmt.setInt(4, memberVo.getId());
			if (pstmt.executeUpdate() == 1) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null ) pstmt.close();}
			catch (SQLException e) {e.printStackTrace();}
			try { if(conn != null ) conn.close();}
			catch (SQLException e) {e.printStackTrace();}
		}
		
		return isSuccess;
	}

	@Override
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean isSuccess = false;
		try {
			conn = DBConnection.dbConn();
			pstmt = conn.prepareStatement("delete from member where id = ?");
			pstmt.setInt(1, id);
			if(pstmt.executeUpdate() == 1) {
				isSuccess = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null ) pstmt.close();}
			catch (SQLException e) {e.printStackTrace();}
			try { if(conn != null ) conn.close();}
			catch (SQLException e) {e.printStackTrace();}
		}
		
		
		return isSuccess;
	}


}
