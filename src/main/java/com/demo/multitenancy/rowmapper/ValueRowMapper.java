package com.demo.multitenancy.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.multitenancy.model.ValueModel;

public class ValueRowMapper implements RowMapper<ValueModel> {

	@Override
	public ValueModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ValueModel value = new ValueModel();
		value.setId(rs.getLong("ID"));
		value.setValue(rs.getString("VALUE"));
		value.setDatabase(rs.getString("DB"));
		return value;
	}
}
