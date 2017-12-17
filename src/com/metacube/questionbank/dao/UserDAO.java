/**
 * 
 */
package com.metacube.questionbank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.questionbank.jdbc.QuestionRowMapper;
import com.metacube.questionbank.jdbc.UserRowMapper;
import com.metacube.questionbank.model.Question;
import com.metacube.questionbank.model.User;

/**
 * @author Admin39
 *
 */
@Repository
public class UserDAO {

	@Autowired
	DataSource dataSource;

	/*
	 * inserting User in database
	 */
	public void insertUser(User user) {

		String sql = "INSERT INTO users "
				+ "(user_id,email,name, Gender, password,about_me,status,rating) VALUES (?,?,?,?,?,?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getUser_id(), user.getEmail(),user.getName(), user.getGender(),
						user.getPassword(),user.getAbout_me(),user.getStatus(),0});

	}

	public void updateData(User user) {
		String sql = "UPDATE users set user_id = ?,email = ?, gender = ?,password=?,about_me=?,status=?,rating=?  where userId = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getUser_id(), user.getEmail(), user.getGender(),
						user.getPassword(),user.getAbout_me(),user.getStatus(),user.getRating(),user.getUser_id()});
	}

	public List<Question> getQuestions() {
		List qUList = new ArrayList();
		String sql = "select * from questions";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		qUList = jdbcTemplate.query(sql, new QuestionRowMapper());
		return qUList;
	}
	public User isValidUser(String email,String password)
	{String sql = "select * from users where email=? and  password=?" ;

	User user =null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		user=(User) jdbcTemplate.queryForObject(sql, new Object[] { email,password }, new UserRowMapper());
System.out.println(user.getEmail() + "Email " + user.getPassword() + " pass " + user.getUser_id() +  "id in DAO");

		

		return user;
		
	}

	public User authenticate(User user) {
		
		return    isValidUser(user.getEmail(), user.getPassword());
		
		
	}
}
