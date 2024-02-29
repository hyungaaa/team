package Mng;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userMngDAO {

	// select
	public List selectEmp(userMngDTO usermngDTO) {
		List list = new ArrayList();

		// DB 접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott_jal";
		String password = "jal123456";

		try {
			// 드라이버 로딩
			// Class.forName : String 변수로 class 생성
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

			// SQL 만들기
			String query = "";
			query += " select";
			query += " uname, unum, cname, ulevel, updv, updior, updr, updiom, updm, uum";
			query += " from";
			query += " user_info";
			query += " select";
			query += " rcategory, unum, uuid, uemail";
			query += " from";
			query += " req_list";

			System.out.println("query : " + query);

			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();

			// 결과 활용
			while (rs.next()) {
				String uname = rs.getString("uname");
				String unum = rs.getString("unum");
				String cname = rs.getString("cname");
				String ulevel = rs.getString("ulevel");
				String updv = rs.getString("updv");
				String updior = rs.getString("updior");
				String updr = rs.getString("updr");
				String updiom = rs.getString("updiom");
				String updm = rs.getString("updm");
				String uum = rs.getString("uum");
				String uuid = rs.getString("uuid");
				String rid = rs.getString("rid");
				String rcategory = rs.getString("rcategory");

				// 날짜 사용하고 싶으면 클래스명이 같기 때문에
				// java.util.Date 이 형태로 써야 한다

				System.out.println("uname : " + uname);
				System.out.println("unum : " + unum);
				System.out.println("cname : " + cname);
				System.out.println("ulevel : " + ulevel);
				System.out.println("updv : " + updv);
				System.out.println("updior : " + updior);
				System.out.println("updr : " + updr);
				System.out.println("updiom : " + updiom);
				System.out.println("updm : " + updm);
				System.out.println("uum : " + uum);
				System.out.println("uuid : " + uuid);
				System.out.println("rid : " + rid);
				System.out.println("rcategory : " + rcategory);
				System.out.println("----------------------------");

//				Map map = new HashMap();
//				map.put("empno", empno);
//				map.put("ename", ename);
//				map.put("hiredate", hiredate);
//				list.add(map);

				userMngDTO dto = new userMngDTO();
				dto.setUname(uname);
				dto.setUnum(unum);
				dto.setCname(cname);
				dto.setUlevel(ulevel);
				dto.setUpdv(updv);
				dto.setUpdior(updior);
				dto.setUpdr(updr);
				dto.setUpdiom(updiom);
				dto.setUpdm(updm);
				dto.setUum(uum);
				dto.setUuid(uuid);
				dto.setRid(rid);
				dto.setRcategory(rcategory);
				list.add(dto);

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

	// update
	// insert
	// delete

}
