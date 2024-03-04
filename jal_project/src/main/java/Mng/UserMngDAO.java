package Mng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMngDAO {

	public List<UserMngDTO> selectAllTables() {
		List<UserMngDTO> list = new ArrayList<>();
//		List<UserMngDTO> list2 = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();

			// user_info 테이블 조회
			String queryUserInfo = " SELECT uuid, ccode, upass, uname, utel, uemail, unum, uposition, ubirth, uimage, udate, umaster FROM user_info";
			ps = con.prepareStatement(queryUserInfo);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
				list.add(dto);
			}

			// center_list 테이블 조회
			String queryCenterList = " SELECT ccode, cname, cmanager, ctel FROM center_list";
			ps = con.prepareStatement(queryCenterList);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
				list.add(dto);
			}

			// req_list 테이블 조회
			String queryReqList = " SELECT rid, uuid, rcategory FROM req_list";
			ps = con.prepareStatement(queryReqList);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
				list.add(dto);
			}
//			// req_list 테이블 조회2
//			String queryReqList2 = "SELECT rid, uuid, rcategory FROM req_list";
//			ps = con.prepareStatement(queryReqList2);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
//				list2.add(dto);
//			}
//			String queryUserInfo2 = "SELECT unum FROM user_info";
//			ps = con.prepareStatement(queryUserInfo2);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
//				list2.add(dto);
//			}

			// user_power 테이블 조회
			String queryUserPower = " SELECT uuid, ulevel, updv, updior, updr, updiom, ubdm, uum FROM user_power";
			ps = con.prepareStatement(queryUserPower);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
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

	private Connection getConn() {
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
			e.printStackTrace();
		}

		return con;
	}

	private UserMngDTO createUserMngDTOFromResultSet(ResultSet rs) throws SQLException {
		UserMngDTO dto = new UserMngDTO();
		// 각 필드에 데이터 설정
		dto.setUuid(rs.getString("uuid"));
		dto.setCcode(rs.getString("ccode"));
		dto.setUpass(rs.getString("upass"));
		dto.setUname(rs.getString("uname"));
		dto.setUtel(rs.getString("utel"));
		dto.setUemail(rs.getString("uemail"));
		dto.setUnum(rs.getString("unum"));
		dto.setUposition(rs.getString("uposition"));
		dto.setUbirth(rs.getDate("ubirth"));
		dto.setUimage(rs.getString("uimage"));
		dto.setUdate(rs.getDate("udate"));
		dto.setUmaster(rs.getString("umaster"));

		// center_list 테이블의 경우 추가 정보 설정
		if (rs.getMetaData().getColumnCount() == 4) {
			dto.setCname(rs.getString("cname"));
			dto.setCmanager(rs.getString("cmanager"));
			dto.setCtel(rs.getString("ctel"));
		}

		// req_list 테이블의 경우 추가 정보 설정
		if (rs.getMetaData().getColumnCount() == 3) {
			dto.setRid(rs.getString("rid"));
			dto.setRcategory(rs.getString("rcategory"));
		}

		// user_power 테이블의 경우 추가 정보 설정
		if (rs.getMetaData().getColumnCount() == 8) {
			dto.setUlevel(rs.getString("ulevel"));
			dto.setUpdv(rs.getString("updv"));
			dto.setUpdior(rs.getString("updior"));
			dto.setUpdr(rs.getString("updr"));
			dto.setUpdiom(rs.getString("updiom"));
			dto.setUbdm(rs.getString("ubdm"));
			dto.setUum(rs.getString("uum"));
		}

		return dto;
	}

	public boolean deleteUser(String userId) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();
			String deleteUserQuery = "DELETE FROM user_info WHERE uuid = ?";
			ps = con.prepareStatement(deleteUserQuery);
			ps.setString(1, userId);
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
