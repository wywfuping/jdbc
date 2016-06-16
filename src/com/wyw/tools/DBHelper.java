package com.wyw.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	private String url;
	private Connection conn = null;
	private PreparedStatement stat = null;
	private ResultSet rs = null;

	public DBHelper(String url) {
		this.url = url;
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("获取连接失败");
		}
	}

	public void getStatement(String sql){
		getConnection();
		try {
			stat=conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("获取接口失败");
		}
	}
	
	public int doUpdate(String sql,Object...paras){
		getStatement(sql);
		try {
			for (int i = 0; i < paras.length; i++) {
				stat.setObject(i+1, paras[i]);
			}
			return stat.executeUpdate();
		} catch (SQLException e) {
			System.out.println("doUpdate error");
			return -1;
		}finally{
			closeConn();
		}
	}

	public ResultSet doQuery(String sql,Object...paras){
		getStatement(sql);
		try {
			for (int i = 0; i < paras.length; i++) {
				stat.setObject(i+1, paras[i]);
			}
			return stat.executeQuery();
		} catch (SQLException e) {
			System.out.println("doQuery error");
			return null;
		}finally{
			closeConn();
		}
	}


	
	public void closeConn(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
