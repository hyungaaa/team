package jal_project_lim;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class itemMngDAO {


	public List<Map<String, String>> selectEmp() {
	    List<Map<String, String>> list = new ArrayList<>();

	    // DB 접속 정보
	    String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	    String user = "scott_jal";
	    String password = "jal123456";

	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        // JDBC 드라이버 로딩
	        Class.forName(driver);

	        // 데이터베이스 연결
	        con = DriverManager.getConnection(url, user, password);

	        // SQL 작성
	        String query = "SELECT pname, scid, pnum, wzone, pday, psize FROM pd_list";

	        // SQL 실행 준비
	        ps = con.prepareStatement(query);

	        // SQL 실행 및 결과 확보
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            // 데이터베이스로부터 읽어온 값을 Map에 설정
	            String pname = rs.getString("pname");
	            String scid = rs.getString("scid");
	            String pnum = rs.getString("pnum");
	            String wzone = rs.getString("wzone");
	            String pday = rs.getString("pday");
	            String psize = rs.getString("psize");

	            // Map에 데이터 추가
	            Map<String, String> map = new HashMap<>();
	            map.put("pname", pname);
	            map.put("scid", scid);
	            map.put("pnum", pnum);
	            map.put("wzone", wzone);
	            map.put("pday", pday);
	            map.put("psize", psize);
	            list.add(map);
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 연결 해제
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return list;
	}
	
}

