package com.wyw.entity;

public class Student {
	private String studentno;
	private String name;
	private String id_card;
	private boolean sex;
	private String phone;
	private String address;
	private String email;
	private Integer majorid;
	public String getStudentno() {
		return studentno;
	}
	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public boolean getSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMajorid() {
		return majorid;
	}
	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}

	
}
