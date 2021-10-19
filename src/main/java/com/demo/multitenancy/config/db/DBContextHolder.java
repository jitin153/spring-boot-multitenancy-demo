package com.demo.multitenancy.config.db;

import org.springframework.util.Assert;

public class DBContextHolder {
	private static final ThreadLocal<DatabaseType> CONTEXT_HOLDER = new ThreadLocal<DatabaseType>();

	public static void setDatabaseType(DatabaseType databaseType) {
		Assert.notNull(databaseType, "customerType cannot be null");
		CONTEXT_HOLDER.set(databaseType);
	}

	public static DatabaseType getDatabaseType() {
		return (DatabaseType) CONTEXT_HOLDER.get();
	}

	public static void clearDatabaseType() {
		CONTEXT_HOLDER.remove();
	}
}
