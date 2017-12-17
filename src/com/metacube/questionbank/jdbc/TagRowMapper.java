package com.metacube.questionbank.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.questionbank.model.Tag;

public class TagRowMapper  implements RowMapper<Tag> {

	@Override
	public Tag mapRow(ResultSet resultSet, int line) throws SQLException {
		TagExtractor  tagExtractor = new TagExtractor();
		return tagExtractor.extractData(resultSet);
	}

}
