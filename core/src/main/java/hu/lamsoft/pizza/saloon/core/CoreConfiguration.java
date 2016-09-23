package hu.lamsoft.pizza.saloon.core;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import hu.lamsoft.pizza.saloon.core.common.modelmapper.service.ModelMapperService;
import hu.lamsoft.pizza.saloon.core.common.modelmapper.service.impl.ModelMapperServiceImpl;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class CoreConfiguration {

	@Autowired
	private DataSource dataSource;

	@Bean(initMethod = "migrate")
	public Flyway flyway(Environment env) {
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource(dataSource);

		flyway.setLocations("classpath:db/schema");
		return flyway;
	}

	@Bean
	public ModelMapperService modelMapperService() {
		return new ModelMapperServiceImpl(new ModelMapper());
	}
	
}
