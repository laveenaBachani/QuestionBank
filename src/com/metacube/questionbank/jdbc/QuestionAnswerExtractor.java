package com.metacube.questionbank.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.metacube.questionbank.model.Answer;

public class QuestionAnswerExtractor implements ResultSetExtractor<Answer> {

	public Answer extractData(ResultSet resultSet) throws SQLException,
	DataAccessException {

	Answer answer=new Answer();
	answer.setAnsId(resultSet.getInt(1));
	answer.setAnswerDesc(resultSet.getString(2));
	answer.setUserId(resultSet.getInt(3));
	//answer.setAnswerDate(resultSet.getTimestamp(4));
	answer.setQuestionId(resultSet.getInt(5));
	return answer;
	}	
}
