package y_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardListDAO {

	// select
	public List selectBoard(BoardListDTO dto) {
		List list = new ArrayList();
		// DB 접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";

		// 드라이버 로딩
		// Class.forName : String 변수로 class 생성
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

			// SQL 만들기
			String query = "";
			query += " select";
			query += " *";
			query += " from";
			query += " bd_list";
//			query += " where bno = ?";
//			query += " and lower(uuid) like '%' || lower(?) || '%'";
			System.out.println("query : " + query);

			// SQL 실행준비
			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1, dto.getBno());
//			ps.setString(2, dto.getUuid());

			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();

			// 결과 활용
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String uuid = rs.getString("uuid");
				String btitle = rs.getString("btitle");
				String pnum = rs.getString("pnum");
				String bdate = rs.getString("bdate");
				int bbits = rs.getInt("bbits");

				BoardListDTO dto1 = new BoardListDTO();
				dto1.setBno(bno);
				dto1.setUuid(uuid);
				dto1.setPnum(pnum);
				dto1.setBtitle(btitle);
				dto1.setBdate(bdate);
				dto1.setBbits(bbits);
				list.add(dto1);

			}

			rs.close();
			ps.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

//	private Connection getConn() {
//		// DB 접속
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
//		String user = "scott_jal";
//		String password = "jal123456";
//
//		Connection con = null;
//		
//		try {
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//
//			con = DriverManager.getConnection(url, user, password);
//			System.out.println("Connection 생성 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return con;
//	}

	// update
//	public int updateBdl(BoardListDTO dto) {
//		int result = -1;
//		
//		// DB 접속
//		Connection con = getConn();
//		
//		// SQL 준비 및 실행
//		String sql = "";	
//		sql += " update bdl2";
//		sql += " set uuid = ?";
//		sql += " where bno = ?";
//		
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1,dto.getBno());
//			ps.setString(2,dto.getUuid());
//			
//			
//			result = ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

	// 결과 활용
//		return result;
//		
//		
//	}

	// insert
	// delete
}