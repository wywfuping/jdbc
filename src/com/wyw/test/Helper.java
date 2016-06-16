package com.wyw.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
	public static void closeConn(Connection conn,Statement stat,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stat!=null){
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
