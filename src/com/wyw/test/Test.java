package com.wyw.test;

import java.sql.Connection;
import java.util.Scanner;

import com.wyw.dao.AdminDao;
import com.wyw.dao.StudentDao;
import com.wyw.entity.Admin;
import com.wyw.entity.Student;

public class Test {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		
		Class type = Student.class;
		Class<Student> atype = type;
		Student stu = creatEntity(type);
		
		
		
	}
	
	static <T> T creatEntity(Class<T> type){
		T t=null;
		try {
			return type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
