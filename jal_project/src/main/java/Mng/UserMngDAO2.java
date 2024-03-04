package Mng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMngDAO2 {

	public List<UserMngDTO2> selectAllTables() {
		List<UserMngDTO2> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();

			// user_info 테이블 조회
			String queryUserInfo = " SELECT unum FROM user_info";
			ps = con.prepareStatement(queryUserInfo);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO2 dto = createUserMngDTOFromResultSet(rs);
				list.add(dto);
			}

			// req_list 테이블 조회
			String queryReqList = " SELECT rid, rcategory, uemail, uuid FROM req_list";
			ps = con.prepareStatement(queryReqList);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO2 dto = createUserMngDTOFromResultSet(rs);
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
		return list;
	}

	private Connection getConn() throws SQLException {
		// DB 접속 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";

		Connection con = null;
		try {
			// 드라이버 로딩
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");

			// DB 접속
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

		return con;
	}

	private UserMngDTO2 createUserMngDTOFromResultSet(ResultSet rs) throws SQLException {
		// 생성자에 필요한 인자 추출
		UserMngDTO2 dto = new UserMngDTO2();
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			String columnName = metaData.getColumnName(i);
			System.out.println("Column " + i + ": " + columnName);
		}

		// 각 필드에 데이터 설정
		dto.setUuid(rs.getString("uuid"));
		dto.setUemail(rs.getString("uemail"));
		dto.setUnum(rs.getString("unum"));
		dto.setRid(rs.getString("rid"));
		dto.setRcategory(rs.getString("rcategory"));
		return dto;
	}
}
