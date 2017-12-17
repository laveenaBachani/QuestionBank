package com.metacube.questionbank.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.metacube.questionbank.model.Tag;

public class TagExtractor implements ResultSetExtractor<Tag> {

	public Tag extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Tag tag=new Tag();
		
		tag.setTagId(resultSet.getInt(1));
		tag.setTagName(resultSet.getString(2));
		tag.setTagDesc(resultSet.getString(3));
		tag.setNoOfQues(resultSet.getInt(4));
		return tag;
	}	}