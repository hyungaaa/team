package Mng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMngDAO2 {

	public List<UserMngDTO2> selectAllTables2() throws SQLException {
		List<UserMngDTO2> resultList2 = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();

			// user_info 테이블 조회
			String queryUserInfo = "SELECT unum FROM user_info";
			ps = con.prepareStatement(queryUserInfo);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO2 dto = new UserMngDTO2();
				dto.setUnum(rs.getString("unum"));
				resultList2.add(dto);
			}

			// req_list 테이블 조회
			String queryReq_List = "SELECT rcategory, uuid, uemail FROM req_list";
			ps = con.prepareStatement(queryReq_List);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO2 dto = new UserMngDTO2();
				dto.setRcategory(rs.getString("rcategory"));
				dto.setUuid(rs.getString("uuid"));
				dto.setUemail(rs.getString("uemail"));
				resultList2.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Database error: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultList2;
	}

	private Connection getConn() throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";

		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Database driver not found: " + e.getMessage());
		} catch (SQLException e) {
			throw e;
		}

		return con;
	}
}
