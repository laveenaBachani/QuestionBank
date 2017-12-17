/**
 * 
 */
package com.metacube.questionbank.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Admin39
 *
 */
@Repository
public class VoteDAO {
	@Autowired
	DataSource dataSource;

	public Integer getUpvotesForAnswer(int answerId) {
		String sql = "select count(upvote_status) from votes where answer_id="
				+ answerId + " and upvote_status=1";

		int count;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		count = jdbcTemplate.queryForInt(sql);
		// System.out.println(count);
		return count;

	}

	public int getdownvotesForAnswer(int answerId) {

		String sql = "select count(upvote_status) from votes where answer_id="
				+ answerId + " and upvote_status=-1";
		int count;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		count = jdbcTemplate.queryForInt(sql);
		
		return count;
	}

}
