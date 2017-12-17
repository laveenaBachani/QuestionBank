/**
 * 
 */
package com.metacube.questionbank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.metacube.questionbank.jdbc.QuestionAnswerRowMapper;
import com.metacube.questionbank.model.Answer;

/**
 * @author Admin39
 *
 */
public class AnswerDAO {

	@Autowired
	DataSource dataSource;

	public void insertAnswer(Answer answer) {

		String sql = "INSERT INTO answers (answer, user_id,ques_id) VALUES (?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	/*	jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement prepStmt)
					throws SQLException, DataAccessException {
				prepStmt.setString(1, answer.getAnswerDesc());
				prepStmt.setInt(2, answer.getUserId());
				prepStmt.setInt(3, answer.getQuestionId());
				return prepStmt.execute();
			}
		});*/
			
		jdbcTemplate.update(
				sql,
				new Object[] {answer.getAnswerDesc(),answer.getUserId(),answer.getQuestionId() });

	}
	
	
	
		public List<Answer> getAnswers(int quesId) {
				List<Answer> qUList = new ArrayList<Answer>();
				String sql = "select * from answers where ques_id="+quesId;
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				qUList = jdbcTemplate.query(sql,  new QuestionAnswerRowMapper());
				return qUList;
			}



		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<Answer> getAnswersByUserId(int userId) {
			// TODO Auto-generated method stub
			List qUList = new ArrayList();
			String sql = "select answers.answer_Id,answer,user_Id,ques_id,answer_date from answers natural join users where user_id="+userId;
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			qUList = jdbcTemplate.query(sql,  new QuestionAnswerRowMapper());
			return qUList;
		}



		public List<Answer> getAnswerLikedByUser(int userId) {
			// TODO Auto-generated method stub
		
			List<Answer> qUList = new ArrayList<Answer>();
			String sql = " select answers.answer_Id,answer,votes.user_Id,ques_id,answer_date from answers natural "+
"join users join votes on votes.answer_id=answers.answer_id where votes.user_Id="+userId+
 " and upvote_status=1;";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			qUList = jdbcTemplate.query(sql,  new QuestionAnswerRowMapper());
			return qUList;
		}
		
	
}
