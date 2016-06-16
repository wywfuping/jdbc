package com.wyw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wyw.entity.Result;
import com.wyw.tools.Conf;
import com.wyw.tools.DBHelper;

public class ResultDao {
	DBHelper db = new DBHelper(Conf.DB_URL);
	
	public int removeById(Integer id){
		String sql= "DELETE FROM result WHERE id=?";
		return db.doUpdate(sql, id);
	}
	
	public int addResult(Result result){
		String sql = "INSERT INTO result(`id`,`studentno`,`subjectid`,`score`,`examdate`) VALUES(?,?,?,?,?)";
		return db.doUpdate(sql, result.getId(),result.getStudentno(),
				result.getSubjectid(),result.getScore(),result.getExamdate());
	}
	
	public int modifyById(Result result){
		String sql = "update result set studentno=?,subjectid=?,score=?,examdate=? where id=?";
		return db.doUpdate(sql, result.getStudentno(),
				result.getSubjectid(),result.getScore(),result.getExamdate(),result.getId());
	}
	
	public Result queryById(Integer id) throws SQLException{
		String sql = "SELECT studentno,subjectid,score,examdate FROM result WHERE id=?";
		ResultSet rs = db.doQuery(sql, id);
		if(rs!=null&&rs.next()){
			Result result = new Result();
			result.setId(rs.getInt("id"));
			result.setStudentno(rs.getString("studentno"));
			result.setSubjectid(rs.getInt("subjectid"));
			result.setScore(rs.getFloat("score"));
			result.setExamdate(rs.getDate("examdate"));
			
			return result;
		}
		return null;
	}

	
}
