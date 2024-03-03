//package Mng
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
//	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private final String URL = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
//	private final String USER = "scott_jal";
//	private final String PASSWORD = "jal123456";
//
//	// select
//	public List<UserMngDTO> selectUserMng() {
//		List<UserMngDTO> list = new ArrayList<>();
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//			// 드라이버 로딩
//			Class.forName(DRIVER);
//			System.out.println("Oracle 드라이버 로딩 성공");
//
//			// DB 접속
//			con = DriverManager.getConnection(URL, USER, PASSWORD);
//			System.out.println("Connection 생성 성공");
//
//			// SQL 생성
//			String query = "SELECT * FROM user_info";
//			System.out.println("query : " + query);
//
//			// SQL 실행 준비
//			ps = con.prepareStatement(query);
//
//			// SQL 실행 및 결과 확보
//			rs = ps.executeQuery();
//
//			// 결과 활용
//			while (rs.next()) {
//				UserMngDTO dto = new UserMngDTO();
//				dto.setUuid(rs.getString("uuid"));
//				dto.setCcode(rs.getString("ccode"));
//				dto.setUpass(rs.getString("upass"));
//				dto.setUname(rs.getString("uname"));
//				dto.setUtel(rs.getString("utel"));
//				dto.setUemail(rs.getString("uemail"));
//				dto.setUnum(rs.getString("unum"));
//				dto.setUposition(rs.getString("uposition"));
//				dto.setUbirth(rs.getDate("ubirth"));
//				dto.setUimage(rs.getString("uimage"));
//				dto.setUdate(rs.getString("udate"));
//				dto.setUmaster(rs.getString("umaster"));
//				dto.setUlevel(rs.getString("ulevel"));
//				dto.setUpdv(rs.getString("updv"));
//				dto.setUpdior(rs.getString("updior"));
//				dto.setUpdr(rs.getString("updr"));
//				dto.setUpdiom(rs.getString("updiom"));
//				dto.setUbdm(rs.getString("ubdm"));
//				dto.setUum(rs.getString("uum"));
//				dto.setRcategory(rs.getString("rcategory"));
//
//				list.add(dto);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// 연결 해제
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
//		return list;
//	}
//
//	// update
//	// insert
//	// delete
//}
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserMngDAO {
//	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private final String URL = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
//	private final String USER = "scott_jal";
//	private final String PASSWORD = "jal123456";
//
//	// select
//	public List<UserMngDTO> selectAllTables() {
//		List<UserMngDTO> list = new ArrayList<>();
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//			// 드라이버 로딩
//			Class.forName(DRIVER);
//			System.out.println("Oracle 드라이버 로딩 성공");
//
//			// DB 접속
//			con = DriverManager.getConnection(URL, USER, PASSWORD);
//			System.out.println("Connection 생성 성공");
//
//			// SQL 생성 - 각 테이블에서 필요한 정보를 가져오도록 쿼리 작성
//			String queryUserInfo = "SELECT * FROM user_info";
//			String queryCenterList = "SELECT * FROM center_list";
//			String queryReqList = "SELECT * FROM req_list";
//			String queryUserPower = "SELECT * FROM user_power";
//
//			// SQL 실행 준비
//			ps = con.prepareStatement(queryUserInfo);
//
//			// SQL 실행 및 결과 확보 - user_info 테이블 정보 가져오기
//			rs = ps.executeQuery();
//
//			// 결과 활용 - UserMngDTO 객체에 필드 설정 후 리스트에 추가
//			while (rs.next()) {
//				UserMngDTO dto = new UserMngDTO();
//				dto.setUserInfoUuid(rs.getString("uuid"));
//				dto.setUserInfoCcode(rs.getString("ccode"));
//				dto.setUserInfoUpass(rs.getString("upass"));
//				dto.setUserInfoUname(rs.getString("uname"));
//				dto.setUserInfoUtel(rs.getString("utel"));
//				dto.setUserInfoUemail(rs.getString("uemail"));
//				dto.setUserInfoUnum(rs.getString("unum"));
//				dto.setUserInfoUposition(rs.getString("uposition"));
//				dto.setUserInfoUbirth(rs.getDate("ubirth"));
//				dto.setUserInfoUimage(rs.getString("uimage"));
//				dto.setUserInfoUdate(rs.getString("udate"));
//				dto.setUserInfoUmaster(rs.getString("umaster"));
//				dto.setUserInfoUlevel(rs.getString("ulevel"));
//				dto.setUserInfoUpdv(rs.getString("updv"));
//				dto.setUserInfoUpdior(rs.getString("updior"));
//				dto.setUserInfoUpdr(rs.getString("updr"));
//				dto.setUserInfoUpdiom(rs.getString("updiom"));
//				dto.setUserInfoUbdm(rs.getString("ubdm"));
//				dto.setUserInfoUum(rs.getString("uum"));
//				dto.setReqListRcategory(rs.getString("rcategory"));
//
//				list.add(dto);
//			}
//
//			// CenterListDTO 정보 가져오기
//			ps = con.prepareStatement(queryCenterList);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				UserMngDTO dto = new UserMngDTO();
//				dto.setCenterListCcode(rs.getString("ccode"));
//				dto.setCenterListCname(rs.getString("cname"));
//				dto.setCenterListCmanager(rs.getString("cmanager"));
//				dto.setCenterListCtel(rs.getString("ctel"));
//				list.add(dto);
//			}
//
//			// ReqListDTO 정보 가져오기
//			ps = con.prepareStatement(queryReqList);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				UserMngDTO dto = new UserMngDTO();
//				dto.setReqListRid(rs.getString("rid"));
//				dto.setReqListUuid(rs.getString("uuid"));
//				dto.setReqListRcategory(rs.getString("rcategory"));
//				list.add(dto);
//			}
//
//			// UserPowerDTO 정보 가져오기
//			ps = con.prepareStatement(queryUserPower);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				UserMngDTO dto = new UserMngDTO();
//				dto.setUserPowerUuid(rs.getString("uuid"));
//				dto.setUserPowerUlevel(rs.getString("ulevel"));
//				dto.setUserPowerUpdv(rs.getString("updv"));
//				dto.setUserPowerUpdior(rs.getString("updior"));
//				dto.setUserPowerUpdr(rs.getString("updr"));
//				dto.setUserPowerUpdiom(rs.getString("updiom"));
//				dto.setUserPowerUbdm(rs.getString("ubdm"));
//				dto.setUserPowerUum(rs.getString("uum"));
//				list.add(dto);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// 연결 해제
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
//		return list;
//	}
//
//	// update
//	// insert
//	// delete
//}

package Mng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMngDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	private final String USER = "scott_jal";
	private final String PASSWORD = "jal123456";

	public List<UserMngDTO> selectAllTables() {
		List<UserMngDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			System.out.println("Oracle 드라이버 로딩 성공");

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection 생성 성공");

			// 모든 테이블의 데이터를 가져오는 쿼리
			String query = "SELECT * FROM user_info " + "UNION ALL " + "SELECT * FROM center_list " + "UNION ALL "
					+ "SELECT * FROM req_list " + "UNION ALL " + "SELECT * FROM user_power";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserMngDTO dto = new UserMngDTO();
				// 각 필드에 데이터 설정
				dto.setUserInfoUuid(rs.getString("uuid"));
				dto.setUserInfoCcode(rs.getString("ccode"));
				dto.setUserInfoUpass(rs.getString("upass"));
				dto.setUserInfoUname(rs.getString("uname"));
				dto.setUserInfoUtel(rs.getString("utel"));
				dto.setUserInfoUemail(rs.getString("uemail"));
				dto.setUserInfoUnum(rs.getString("unum"));
				dto.setUserInfoUposition(rs.getString("uposition"));
				dto.setUserInfoUbirth(rs.getDate("ubirth"));
				dto.setUserInfoUimage(rs.getString("uimage"));
				dto.setUserInfoUdate(rs.getString("udate"));
				dto.setUserInfoUmaster(rs.getString("umaster"));
				dto.setUserInfoUlevel(rs.getString("ulevel"));
				dto.setUserInfoUpdv(rs.getString("updv"));
				dto.setUserInfoUpdior(rs.getString("updior"));
				dto.setUserInfoUpdr(rs.getString("updr"));
				dto.setUserInfoUpdiom(rs.getString("updiom"));
				dto.setUserInfoUbdm(rs.getString("ubdm"));
				dto.setUserInfoUum(rs.getString("uum"));
				dto.setCenterListCcode(rs.getString("ccode"));
				dto.setCenterListCname(rs.getString("cname"));
				dto.setCenterListCmanager(rs.getString("cmanager"));
				dto.setCenterListCtel(rs.getString("ctel"));
				dto.setReqListRid(rs.getString("rid"));
				dto.setReqListUuid(rs.getString("uuid"));
				dto.setReqListRcategory(rs.getString("rcategory"));
				dto.setUserPowerUuid(rs.getString("uuid"));
				dto.setUserPowerUlevel(rs.getString("ulevel"));
				dto.setUserPowerUpdv(rs.getString("updv"));
				dto.setUserPowerUpdior(rs.getString("updior"));
				dto.setUserPowerUpdr(rs.getString("updr"));
				dto.setUserPowerUpdiom(rs.getString("updiom"));
				dto.setUserPowerUbdm(rs.getString("ubdm"));
				dto.setUserPowerUum(rs.getString("uum"));
				list.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
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
}
