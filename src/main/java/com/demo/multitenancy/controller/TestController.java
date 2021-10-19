package com.demo.multitenancy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.multitenancy.config.db.DBContextHolder;
import com.demo.multitenancy.config.db.DatabaseType;
import com.demo.multitenancy.model.ValueModel;
import com.demo.multitenancy.rowmapper.ValueRowMapper;

@RestController
public class TestController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String FIND_BY_ID = "select * from tbl_test where id = ?";

	@GetMapping("/oracle/test/{id}")
	public ValueModel testOracle(@PathVariable("id") Long id) {
		DBContextHolder.setDatabaseType(DatabaseType.ORACLE);
		ValueModel value = jdbcTemplate.queryForObject(FIND_BY_ID, new Object[] { id }, new ValueRowMapper());
		return value;
	}

	@GetMapping("/mysql/test/{id}")
	public ValueModel testMySql(@PathVariable("id") Long id) {
		DBContextHolder.setDatabaseType(DatabaseType.MYSQL);
		ValueModel value = jdbcTemplate.queryForObject(FIND_BY_ID, new Object[] { id }, new ValueRowMapper());
		return value;
	}
}
