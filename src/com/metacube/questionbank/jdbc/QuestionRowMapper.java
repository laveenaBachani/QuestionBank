package com.metacube.questionbank.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.questionbank.model.Question;


public class QuestionRowMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet resultSet, int line) throws SQLException {
		QuestionExtractor  questionExtractor = new QuestionExtractor();
		return questionExtractor.extractData(resultSet);
	}

}
