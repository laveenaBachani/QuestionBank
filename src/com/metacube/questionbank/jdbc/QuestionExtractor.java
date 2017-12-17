package com.metacube.questionbank.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.metacube.questionbank.model.Question;


public class QuestionExtractor implements ResultSetExtractor<Question> {

	public Question extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Question question=new Question();
		question.setQuesId(resultSet.getInt(1));
		question.setQuestionTitle(resultSet.getString(2));
		question.setQuestionDesc(resultSet.getString(3));
		question.setUserId(resultSet.getInt(4));
		question.setQuestionDate(resultSet.getTimestamp(5));
		question.setClosingDate(resultSet.getDate(6));
		
		
		
		return question;
	}	}