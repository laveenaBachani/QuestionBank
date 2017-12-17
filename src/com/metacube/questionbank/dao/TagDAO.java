/**
 * 
 */
package com.metacube.questionbank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.metacube.questionbank.jdbc.QuestionRowMapper;
import com.metacube.questionbank.jdbc.TagRowMapper;
import com.metacube.questionbank.model.Question;
import com.metacube.questionbank.model.Tag;

public class TagDAO {
	@Autowired
	DataSource dataSource;
	
	public List<Tag> getTags() {
		List tagList = new ArrayList();
		String sql = "select * from tags";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		tagList = jdbcTemplate.query(sql, new TagRowMapper());
	
		return tagList;
	}

	public List<Question> getTagQuestions(int tag_id) {
		List tagQuestionsList = new ArrayList();
		String sql = "select q.ques_id,q.ques_title,q.ques_desc,q.user_id,q.ques_date,q.closing_date from questions q,Questiontags tq where q.ques_id=tq.ques_id and tq.tag_id='"+tag_id+"'";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		tagQuestionsList = jdbcTemplate.query(sql, new QuestionRowMapper());
	System.out.println(tagQuestionsList + "in DAP");
		return tagQuestionsList;
	}
	
	 public List<Tag> getMatchedTag(String tagName) {
		 List<Tag> tagList = new ArrayList<Tag>();
			String sql = "select * from tags where tag_name like '"+tagName+"%'";

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			tagList = jdbcTemplate.query(sql, new TagRowMapper());
		System.out.println(tagList + "in DAP");
			return tagList;
		}

}