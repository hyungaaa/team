//package com.spring.Mng;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserMngDAO {
//
//	public List<UserMngDTO> selectAllTables() {
//		List<UserMngDTO> resultList = new ArrayList<UserMngDTO>();
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//			con = getConn();
//
//			// user_info와 user_power를 uuid로 조인하여 데이터 조회
//			String queryAllTables = "SELECT u.uname, u.unum, u.uposition, p.updv, p.updior, p.updiom, p.updr, p.ubdm, p.uum "
//					+ "FROM user_info u " + "JOIN user_power p ON u.uuid = p.uuid";
//
//			ps = con.prepareStatement(queryAllTables);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
//				resultList.add(dto);
//			}
//
//			// center_list 테이블 조회
//			String queryCenterList = "SELECT cname FROM center_list";
//			ps = con.prepareStatement(queryCenterList);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				UserMngDTO dto = new UserMngDTO();
//				dto.setCname(rs.getString("cname"));
//				resultList.add(dto);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Database error: " + e.getMessage());
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (ps != null)
//					ps.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return resultList;
//	}
//
//	private Connection getConn() throws SQLException {
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
//		String user = "scott_jal";
//		String password = "jal123456";
//
//		Connection con = null;
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException e) {
//			throw new SQLException("Database driver not found: " + e.getMessage());
//		} catch (SQLException e) {
//			throw e;
//		}
//
//		return con;
//	}
//
//	private UserMngDTO createUserMngDTOFromResultSet(ResultSet rs) throws SQLException {
//		UserMngDTO dto = new UserMngDTO();
//
//		dto.setUname(rs.getString("uname"));
//		dto.setUnum(rs.getString("unum"));
//		dto.setUposition(rs.getString("uposition"));
//		dto.setUpdv(rs.getString("updv"));
//		dto.setUpdior(rs.getString("updior"));
//		dto.setUpdiom(rs.getString("updiom"));
//		dto.setUpdr(rs.getString("updr"));
//		dto.setUbdm(rs.getString("ubdm"));
//		dto.setUum(rs.getString("uum"));
//
//		return dto;
//	}
//}
package com.spring.Mng;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMngDAO {

    @Autowired
    private SqlSession sqlSession;

    public List<UserMngDTO> selectInfoPower() {
        return sqlSession.selectList("mapper.userMng.infoPower");
    }

    public List<UserMngDTO> selectCenterList() {
        return sqlSession.selectList("mapper.userMng.centerList");
    }
}
