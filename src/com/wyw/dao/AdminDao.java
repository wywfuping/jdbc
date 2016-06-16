package com.wyw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wyw.entity.Admin;
import com.wyw.entity.Student;
import com.wyw.tools.Conf;
import com.wyw.tools.DBHelper;

public class AdminDao {
	DBHelper db = new DBHelper(Conf.DB_URL);

	public int removeById(int id) {
		String sql = "delete from admin where id=?";
		return db.doUpdate(sql, id);
	}

	public int addId(Admin adm) {
		String sql = "INSERT INTO admin(id,`name`,pwd) VALUES(?,?,?)";
		return db.doUpdate(sql, adm.getId(), adm.getName(), adm.getPwd());
	}

	public int modifyById(Admin adm) {
		String sql = "update admin set `name`=?,pwd=? where id=?";
		return db.doUpdate(sql, adm.getName(), adm.getPwd(), adm.getId());
	}

	public Admin queryById(int id) {
		String sql = "SELECT id,`name`,pwd from admin where id=?";
		ResultSet rs = db.doQuery(sql, id);
		try {
			if (rs != null && rs.next()) {
				Admin adm = new Admin();

				adm.setId(rs.getInt("id"));
				adm.setName(rs.getString("name"));
				adm.setPwd(rs.getString("pwd"));

				return adm;
			}else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			db.closeConn();
		}
	}
	
	public List<Admin> queryAll() {
		String sql = "SELECT id,`name`,pwd from admin where id=?";
		List<Admin> list = new ArrayList<>();
		ResultSet rs = db.doQuery(sql);
		try {
			while(rs != null && rs.next()) {
				Admin adm = new Admin();

				adm.setId(rs.getInt("id"));
				adm.setName(rs.getString("name"));
				adm.setPwd(rs.getString("pwd"));

				list.add(adm);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			db.closeConn();
		}
		return list;
	}
}
