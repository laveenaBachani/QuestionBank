package com.metacube.questionbank.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.metacube.questionbank.model.User;


public class UserExtractor implements ResultSetExtractor<User> {

	public User extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		User user = new User();
		
		user.setUser_id(resultSet.getInt(1));
		
		user.setStatus(resultSet.getInt(1));
		user.setEmail(resultSet.getString(2));
		user.setName(resultSet.getString(3));
		user.setPassword(resultSet.getString(4));
		user.setDob(resultSet.getDate(5));
		user.setGender(resultSet.getString(6));
		
		user.setAbout_me(resultSet.getString(7));
		
		user.setRating(resultSet.getInt(8));
		user.setStatus(resultSet.getInt(9));
		return user;
	}

}
