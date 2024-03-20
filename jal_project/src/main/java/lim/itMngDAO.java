package lim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class itMngDAO {

	//select
	public static List selectMng(itMngDTO itmngDTO) {
		List list = new ArrayList<>();
		
		try {
			
			// DB접속
			Connection con = getConn();
			
			if (con == null) {
	            System.out.println("Connection is null");
	            return list;
	        }
			
			
			// SQL 만들기
			String query = "";
			query += " SELECT pname, sct, pnum, wzone, pday, psize";
			query += " FROM pd_list";
			query += " LEFT OUTER JOIN small_cat ON pd_list.scid = small_cat.scid order by pday";
			
			System.out.println("query : " + query);
			
			//SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
				
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			while (rs.next()) {
				String pnum = rs.getString("pnum");
				String pname = rs.getString("pname");
				String psize = rs.getString("psize");
				String wzone = rs.getString("wzone");
				String sct = rs.getString("sct");
				String pday = rs.getString("pday");
							
				// 콘솔 출력
				System.out.println("pnum : " + pnum);
				System.out.println("pname : " + pname);
				System.out.println("psize : " + psize);
				System.out.println("wzone : " + wzone);
				System.out.println("sct : " + sct);
				System.out.println("pday : " + pday);
				System.out.println("-----------------------------");
							
				// itMngDTO 객체에 저장 후 리스트에 추가
				itMngDTO mng = new itMngDTO();
				mng.setPnum(pnum);
				mng.setPname(pname);
				mng.setPsize(psize);
				mng.setWzone(wzone);
				mng.setSct(sct);
				mng.setPday(pday);
				list.add(mng);
			}
			
			rs.close();
			ps.close();
			con.close();	
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	// DB연결 
	static Connection getConn() {
		// DB 접속
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
//			con = DriverManager.getConnection(url, user, password);
			return DriverManager.getConnection(url, user, password);
//			System.out.println("Connection 생성 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
	
	// 여러 개의 제품을 선택한 경우, IN 절을 사용하여 삭제
    public int deleteSelectedProducts(String[] selectedItems) {
    	System.out.println("deleteProducts 메서드 호출");
    	
        int rowsDeleted = 0;
        Connection con = null;
        
        try {
            con = getConn();
            con.setAutoCommit(false); // 트랜잭션 시작

            rowsDeleted = deleteItems(con, selectedItems);

            con.commit(); // 모든 삭제가 성공하면 커밋

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback(); // 롤백
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            closeDBConnection(con);
        }
        return rowsDeleted;
    }

    // 여러 개의 제품을 삭제하는 메서드
    public int deleteItems(Connection con, String[] selectedItems) throws SQLException {
    	
        int rowsDeleted = 0;

        StringBuilder deleteQuery = new StringBuilder("DELETE FROM pd_list WHERE pnum IN (");
        for (int i = 0; i < selectedItems.length; i++) {
            deleteQuery.append("?");
            if (i < selectedItems.length - 1) {
                deleteQuery.append(",");
            }
        }

        deleteQuery.append(")");

        try (PreparedStatement deletePs = con.prepareStatement(deleteQuery.toString())) {
            // pnum 매개변수 설정
            for (int i = 0; i < selectedItems.length; i++) {
                deletePs.setString(i + 1, selectedItems[i]);
            }
            rowsDeleted = deletePs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return rowsDeleted;
        }
    

	
//	public int deleteProducts(Connection con, String[] productNums)  {
//        int rowsAffected = 0;
//     
//
//        try {
//        	con = getConn();
//            con.setAutoCommit(false); // 트랜잭션 시작
//
//            for (String pnum : productNums) {
//                rowsAffected += deleteProduct(con, pnum);
//            }
//
//            con.commit(); // 모든 삭제가 성공하면 커밋
//            
//        } catch (SQLException e) {
//            try {
//                if (con != null) {
//                    con.rollback(); // 롤백
//                }
//            } catch (SQLException rollbackEx) {
//                rollbackEx.printStackTrace();
//            }
//            e.printStackTrace();
//        } finally {
//            closeDBConnection(con);
//        }
//
//        return rowsAffected;
//    }
    
    public int deleteProducts(Connection con, String[] productNums) throws SQLException {
    	System.out.println("deleteProducts 메서드 호출");
        int rowsAffected = 0;

        try {
            con = getConn();
            con.setAutoCommit(false); // 트랜잭션 시작

            for (String pnum : productNums) {
                rowsAffected += deleteProduct(con, pnum);
            }

            con.commit(); // 모든 삭제가 성공하면 커밋

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback(); // 롤백
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            if (con != null) {
			    closeDBConnection(con);
			}
        }

        return rowsAffected;
     
			}
		
    // 삭제된 상품 수 반환
    public int deleteProduct(Connection con, String productNum) throws SQLException {
        int rowsAffected = 0;

        try (PreparedStatement ps = con.prepareStatement("DELETE FROM pd_list WHERE pnum = ?")) {
            ps.setString(1, productNum);
            rowsAffected = ps.executeUpdate();
        } 
        	return rowsAffected;
    }
    
 // DB 연결 메서드
//    public static Connection getDBConnection() throws SQLException {
//        String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
//        String user = "scott_jal";
//        String password = "jal123456";
//
//        Connection con = null;
//
//        try {
//            // 드라이버 로딩
//            Class.forName(driver);
//            System.out.println("★ Oracle 드라이버 로딩 성공 ★");
//
//            // DB 접속
//            con = DriverManager.getConnection(url, user, password);
//            System.out.println("★ Connection 생성 성공 ★");
//
//            return con;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    
 // DB 연결 닫기 메서드
    public static void closeDBConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println("★ Connection 닫기 성공 ★");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}