package com.wyw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wyw.entity.Student;
import com.wyw.tools.Conf;
import com.wyw.tools.DBHelper;

public class StudentDao {
	DBHelper db = new DBHelper(Conf.DB_URL);

	public int removeByStudentNo(String studentno) {
		String sql = "DELETE FROM student WHERE studentno=?";
		return db.doUpdate(sql, studentno);
	}

	public int addStudent(Student stu) {
		String sql = "INSERT INTO student(`studentno`,`name`,id_card,"
				+ "sex,phone,address,email,majorid) VALUES(?,?,?,?,?,?,?,?)";
		return db.doUpdate(sql, stu.getStudentno(), stu.getName(), stu.getId_card(), stu.getSex(), stu.getPhone(),
				stu.getAddress(), stu.getEmail(), stu.getMajorid());
	}

	public int modifyByStudentNo(Student stu) {
		String sql = "UPDATE student SET name=?,id_card=?,sex=?,phone=?,"
				+ "address=?,email=?,majorid=? where studentno=?";
		return db.doUpdate(sql, stu.getName(), stu.getId_card(), stu.getSex(), stu.getPhone(), stu.getAddress(),
				stu.getEmail(), stu.getMajorid(), stu.getStudentno());
	}

	public Student queryByStudentNo(String studentno) {
		String sql = "SELECT studentno,name,id_card,sex,phone,address,email,"
				+ "majorid FROM student WHERE studentno=? ";
		ResultSet rs = db.doQuery(sql, studentno);
		try {
			if (rs != null && rs.next()) {
				return buildEntity(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			db.closeConn();
		}
	}

	public List<Student> queryAll() {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT studentno,name,id_card,sex,phone,address,email," + "majorid FROM student";
		ResultSet rs = db.doQuery(sql);
		try {
			while (rs != null && rs.next()) {
				list.add(buildEntity(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			db.closeConn();
		}
		return list;
	}

	public Student buildEntity(ResultSet rs) throws SQLException {
		Student stu = new Student();

		stu.setStudentno(rs.getString("studentno"));
		stu.setName(rs.getString("name"));
		stu.setId_card(rs.getString("id_card"));
		stu.setSex(rs.getBoolean("sex"));
		stu.setPhone(rs.getString("phone"));
		stu.setAddress(rs.getString("address"));
		stu.setEmail(rs.getString("email"));
		stu.setMajorid(rs.getInt("majorid"));
		return stu;
	}
}
