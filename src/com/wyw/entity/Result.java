package com.wyw.entity;

import java.security.Timestamp;
import java.util.Date;

public class Result {
	private Integer id;
	private String studentno;
	private Integer subjectid;
	private Float score;
	private Date examdate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentno() {
		return studentno;
	}
	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}
	public Integer getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public Date getExamdate() {
		return examdate;
	}
	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}

}
