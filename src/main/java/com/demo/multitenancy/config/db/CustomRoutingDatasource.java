package com.demo.multitenancy.config.db;

import java.util.Objects;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomRoutingDatasource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		/*
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		String pathInfo = attr.getRequest().getRequestURI();
		return pathInfo.substring(1, 3);
		 */
		DatabaseType db = DBContextHolder.getDatabaseType();
		if (Objects.nonNull(db)) {
			return db.name().toLowerCase();
		}
		return DatabaseType.ORACLE.name().toLowerCase();
	}
}
