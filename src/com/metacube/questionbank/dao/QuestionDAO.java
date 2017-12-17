package com.metacube.questionbank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.metacube.questionbank.jdbc.QuestionRowMapper;
import com.metacube.questionbank.model.Question;

public class QuestionDAO {
@Autowired
DataSource dataSource;
	public List<Question> getQuestions() {
			List<Question> qUList = new ArrayList<Question>();
			String sql = "select * from questions order by ques_date desc";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			qUList = jdbcTemplate.query(sql, new QuestionRowMapper());
			return qUList;
		}
	public List<Question> getQuestionById(int i){
		List<Question> qUList = new ArrayList<Question>();
		String sql="select * from questions where ques_id="+i;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		qUList = jdbcTemplate.query(sql, new QuestionRowMapper());	
		return  qUList;
		
	}
}
