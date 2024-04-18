package com.spring.lee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class InRegDAO {

	//select
	public List selectPd(PdDTO pdDTO, String searchInput) {
		List list = new ArrayList();
		
		try {

			// DB 접속
			connDB();
			
			// SQL 만들기
			String query = "";
			query += " select";
			query += " pnum, pname, psize, punit";
			query += " from";
			query += " pd_list";
			query += " where 1=1 ";
//					+ "and pname like '%' || ? || '%'";
			
			if(searchInput != null) {
				query += " and pname like '%' || ? || '%'";
				System.out.println("11111");
				if(searchInput.startsWith("E")) {
					query += " or pnum = ?";
				}
			} 
//			if(pname != null){
//				query += " and pname like '%' || ? || '%'";
//				System.out.println("222222");
//			}

			System.out.println("query : " + query);
			
			
			
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			if(searchInput != null) {
				ps.setString(1, searchInput);
				System.out.println("11111");
				if(searchInput.startsWith("E")) {
					ps.setString(2, searchInput);
					System.out.println("22222");
				}
			} 
			
//			ps.setString(2, searchInput);
			System.out.println("이건 DAO: searchInput " + searchInput);
			
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			while (rs.next()) {
				String pnum = rs.getString("pnum");
				String pname = rs.getString("pname");
				String psize = rs.getString("psize");
				String punit = rs.getString("punit");
				
				// 콘솔 출력
				System.out.println("pnum : " + pnum);
				System.out.println("pname : " + pname);
				System.out.println("psize : " + psize);
				System.out.println("punit : " + punit);
				System.out.println("-----------------------------");
				
				
				PdDTO dto = new PdDTO();
				dto.setPnum(pnum);
				dto.setPname(pname);
				dto.setPsize(psize);
				dto.setPunit(punit);
				list.add(dto);
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	// select2
	public List selectTbl(PdDTO pdDTO, Pd_inDTO pd_inDTO) {
		List list = new ArrayList();
		List<Object> lists = new ArrayList<Object>();
		
		try {

			// DB 접속
			connDB();
			
			// SQL 만들기
			String query = "";
			query += " select";
			query += " pindate, pd_in.pnum, pname, psize, punit, pincnt, pstate, plot, pnote";
			query += " from";
			query += " pd_list join pd_in";
			query += " on pd_list.pnum = pd_in.pnum";

			System.out.println("query : " + query);
			
			
			
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(2, searchInput);
//			System.out.println("이건 DAO: searchInput " + searchInput);
			
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
//			System.out.println("rs2 " + rs.next());
			// 결과 활용
			while (rs.next()) {
				Date pindate = rs.getDate("pindate");
				String pnum = rs.getString("pnum");
				String pname = rs.getString("pname");
				String psize = rs.getString("psize");
				String punit = rs.getString("punit");
				int pincnt = rs.getInt("pincnt");
				String pstate = rs.getString("pstate");
				String plot = rs.getString("plot");
				String pnote = rs.getString("pnote");
				
				// 콘솔 출력
				System.out.println("pindate : " + pindate);
				System.out.println("pnum : " + pnum);
				System.out.println("pname : " + pname);
				System.out.println("psize : " + psize);
				System.out.println("punit : " + punit);
				System.out.println("pincnt : " + pincnt);
				System.out.println("pstate : " + pstate);
				System.out.println("plot : " + plot);
				System.out.println("pnote : " + pnote);
				System.out.println("-----------------------------");
				
				
				PdDTO dto = new PdDTO();
				Pd_inDTO indto = new Pd_inDTO();
				indto.setPindate(pindate);
				dto.setPnum(pnum);
				dto.setPname(pname);
				dto.setPsize(psize);
				dto.setPunit(punit);
				indto.setPincnt(pincnt);
				indto.setPstate(pstate);
				indto.setPlot(plot);
				indto.setPnote(pnote);
				
				lists.add(dto);
				lists.add(indto);
				list.add(lists);
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	private Connection con;
	
	// DB 연결 메소드
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
	
	//update
	//insert
	int insertPd(Pd_inDTO pd_inDTO) {
		int result = -9999;
		
		connDB();

		PreparedStatement ps = null;
		
		try {
			// SQL 준비
			String query = " insert into pd_in";
			query += " values(?, ?, ?, ?, ?, ?, ?)";

			ps = con.prepareStatement(query);
			ps.setString(1, pd_inDTO.getPlot());
			ps.setString(2, pd_inDTO.getPnum());
			ps.setString(3, pd_inDTO.getWzone());
			ps.setDate(4, pd_inDTO.getPindate());
			ps.setInt(5, pd_inDTO.getPincnt());
			ps.setString(6, pd_inDTO.getPnote());
			ps.setString(7, pd_inDTO.getPstate());

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
			
			if (this.con != null) {
				try {
					this.con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	//delete
}
