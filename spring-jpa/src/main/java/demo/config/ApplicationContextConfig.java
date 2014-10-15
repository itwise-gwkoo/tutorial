package demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;


@Configuration
@ComponentScan(useDefaultFilters = true,
		basePackages = {"demo"},
		excludeFilters = {@ComponentScan.Filter(value = {Controller.class, Configuration.class})})
//@Import(value = {DataSourceConfig.class, MyBatisConfig.class})
@Import(value = {DataSourceConfig.class})
public class ApplicationContextConfig {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private Environment environment;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ApplicationContextConfig() {
		logger.info("===> initialize AppContextConfig");
	}


}