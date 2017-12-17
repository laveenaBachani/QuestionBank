package com.metacube.questionbank.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.questionbank.model.Answer;



public class QuestionAnswerRowMapper implements RowMapper<Answer>{
	
	
	public Answer mapRow(ResultSet resultSet, int line) throws SQLException {
		QuestionAnswerExtractor  questionExtractor = new QuestionAnswerExtractor();
		return questionExtractor.extractData(resultSet);
	}

	
}
