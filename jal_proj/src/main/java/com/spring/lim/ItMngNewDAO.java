package com.spring.lim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ItMngNewDAO {
	
	private Connection con;
	
	// DB 연결
	private void connDB() {
		try {
			
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			this.con = dataFactory.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	int insertIt(ItMngNewDTO itnDTO) {
		int result = -9999;
		
		/* 꼭 써야함!! */
		connDB();
		
		PreparedStatement ps = null;
		
		try {
			// SQL 준비
			String query = " insert into pd_list (img, pname, sct, pnum, wzone, bct, psize, punit, pday)";
			query += 	   " values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			ps = con.prepareStatement(query);
			ps.setString(1, itnDTO.getImg());
			ps.setString(2, itnDTO.getPname());
			ps.setString(3, itnDTO.getSct());
			ps.setString(4, itnDTO.getPnum());
			ps.setString(5, itnDTO.getWzone());
			ps.setString(6, itnDTO.getBct());
			ps.setString(7, itnDTO.getPsize());
			ps.setString(8, itnDTO.getPunit());
			ps.setString(9, itnDTO.getPday());
			

			// SQL 실행 및 결과 확보
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(this.con != null) {
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
	
}
