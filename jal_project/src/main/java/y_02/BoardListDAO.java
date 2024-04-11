package y_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardListDAO {

	private Connection con;

	private void connDB() {
		try {
			
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle2");
			this.con = dataFactory.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// select
	public List selectBoard() {

		connDB();

		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = new ArrayList();

		try {
			// SQL 준비
			String query = "";
			query += " select";
			query += " bd_list.*, user_info.uname";
			query += " from";
			query += " bd_list";
			query += " inner join user_info on bd_list.uuid = user_info.uuid";
			
			
			System.out.println("query : " + query);

			ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();

			// 결과 활용
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String uuid = rs.getString("uuid");
				String btitle = rs.getString("btitle");
				String pnum = rs.getString("pnum");
				String bdate = rs.getString("bdate");
				int bbits = rs.getInt("bbits");
				String uname = rs.getString("uname");
				String btext = rs.getString("btext");

				BoardListDTO dto1 = new BoardListDTO();
				dto1.setBno(bno);
				dto1.setUuid(uuid);
				dto1.setUname(uname);
				dto1.setPnum(pnum);
				dto1.setBtitle(btitle);
				dto1.setBdate(bdate);
				dto1.setBbits(bbits);
				dto1.setBtext(btext);
				list.add(dto1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (this.con != null) {
				try {
					this.con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;

	}

	// select
	public List selectedView(BoardListDTO boardListDTO) {

		connDB();
		List list = new ArrayList();
		// 연결 실패 시

		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM bd_list WHERE bno = ?");
			ps.setInt(1, boardListDTO.getBno());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int bno = rs.getInt("bno");
				String btitle = rs.getString("btitle");
				String bdate = rs.getString("bdate");
				String uname = rs.getString("uname");
				String pnum = rs.getString("pnum");
				String btext = rs.getString("btext");

				list.add(bno);
				list.add(btitle);
				list.add(bdate);
				list.add(uname);
				list.add(pnum);
				list.add(btext);

			}

			// 연결 종료
			rs.close();
			ps.close();
			con.close();

			return list;
		} catch (SQLException e) {
			e.printStackTrace();

			return list;
		}

	}

	// insert

	int insert(BoardListDTO boardListDTO) {
		int result = -9999;
		
		connDB();
		PreparedStatement ps = null;
		
		try {
			// SQL 준비
			String query = " insert into bd_list (bno, btitle, btext) values(seq_bd_list.nextval,?,?)";

			ps = con.prepareStatement(query);
			ps.setString(1, boardListDTO.getBtitle());
			ps.setString(2, boardListDTO.getBtext());

			// SQL 실행 및 결과 확보
			result = ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	// delete
}