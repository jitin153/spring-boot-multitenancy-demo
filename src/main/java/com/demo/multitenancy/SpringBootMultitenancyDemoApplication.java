package com.demo.multitenancy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.demo.multitenancy.config.db.CustomRoutingDatasource;
import com.demo.multitenancy.config.db.DatabaseConfigurations;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
@EnableConfigurationProperties(DatabaseConfigurations.class)
public class SpringBootMultitenancyDemoApplication {

	@Autowired
	DatabaseConfigurations databaseConfigurations;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultitenancyDemoApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		CustomRoutingDatasource dataSource = new CustomRoutingDatasource();
		dataSource.setTargetDataSources(databaseConfigurations.createTargetDataSources());
		return dataSource;
	}
}
