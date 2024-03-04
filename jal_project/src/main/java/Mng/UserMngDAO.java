package Mng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMngDAO {

	public List<List<UserMngDTO>> selectAllTables() {
		List<List<UserMngDTO>> resultList = new ArrayList<>();
		List<UserMngDTO> list = new ArrayList<>();
		List<UserMngDTO> list2 = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();

			// user_info 테이블 조회
			String queryUserInfo = " SELECT * FROM user_info";
			ps = con.prepareStatement(queryUserInfo);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
				list.add(dto);
			}

			// center_list 테이블 조회
			String queryCenterList = " SELECT * FROM center_list";
			ps = con.prepareStatement(queryCenterList);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
				list.add(dto);
				list2.add(dto);
			}

			// req_list 테이블 조회
			String queryReqList = " SELECT * FROM req_list";
			ps = con.prepareStatement(queryReqList);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO dto = createUserMngDTOFromResultSet(rs);
				list.add(dto);
			}

			// req_list2 테이블 조회
			String queryReqList2 = "SELECT uuid, uemail, rid, rcategory FROM req_list";
			ps = con.prepareStatement(queryReqList2);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserMngDTO dto = createUserMngDTOFromResultSet2(rs);
				list2.add(dto);
			}

			// user_power 테이블 조회
			String queryUserPower = " SELECT * FROM user_power";
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
		resultList.add(list);
		resultList.add(list2);
		return resultList;
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

	private UserMngDTO createUserMngDTOFromResultSet2(ResultSet rs) throws SQLException {
		UserMngDTO dto = new UserMngDTO();
		dto.setRid(rs.getString("rid"));
		dto.setRcategory(rs.getString("rcategory"));
		dto.setUuid(rs.getString("uuid"));
		dto.setUemail(rs.getString("uemail"));
		return dto;
	}

	private UserMngDTO createUserMngDTOFromResultSet(ResultSet rs) throws SQLException {
		// 생성자에 필요한 인자 추출
		UserMngDTO dto = new UserMngDTO();
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			String columnName = metaData.getColumnName(i);
			System.out.println("Column " + i + ": " + columnName);
		}

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
		if (columnCount == 4) {
			dto.setCname(rs.getString("cname"));
			dto.setCmanager(rs.getString("cmanager"));
			dto.setCtel(rs.getString("ctel"));
		}

		// req_list 테이블의 경우 추가 정보 설정
		if (columnCount == 3) {
			dto.setRid(rs.getString("rid"));
			dto.setRcategory(rs.getString("rcategory"));
			dto.setRcategory(rs.getString("uemail1"));
			dto.setRcategory(rs.getString("uuid1"));
		}

		// user_power 테이블의 경우 추가 정보 설정
		if (columnCount == 8) {
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

}
