package com.demo.multitenancy.model;

public class ValueModel {
	private Long id;
	private String value;
	private String database;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	@Override
	public String toString() {
		return "ValueModel [id=" + id + ", value=" + value + ", database=" + database + "]";
	}
}
