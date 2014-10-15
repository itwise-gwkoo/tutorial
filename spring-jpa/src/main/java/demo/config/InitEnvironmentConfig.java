package demo.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class InitEnvironmentConfig implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	private static final String[] DEFAULT_ACTIVIE_PROFILES = {"default"};
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void initialize(ConfigurableApplicationContext context) {
		if(context.getEnvironment().getActiveProfiles().length == 0) {
			context.getEnvironment().setActiveProfiles(DEFAULT_ACTIVIE_PROFILES);
		}
		
		logger.info("Using set spring profile. profiles='{}'", context.getEnvironment().getActiveProfiles());
		
		ConfigurableEnvironment env = context.getEnvironment();
		
		env.setDefaultProfiles(DEFAULT_ACTIVIE_PROFILES);
//		env.addActiveProfile("default");
		
		
		List<Resource> resources = new ArrayList<>();
		
		resources.add(new ClassPathResource("db-" + context.getEnvironment().getActiveProfiles()[0] + ".properties"));
		
		
		PropertiesFactoryBean propertiesFactory = new PropertiesFactoryBean();
		propertiesFactory.setLocations(resources.toArray(new Resource[resources.size()]));
	
		MutablePropertySources propertySources = env.getPropertySources();
		try {
			propertiesFactory.afterPropertiesSet();
			propertySources.addLast(new PropertiesPropertySource("dbProp", propertiesFactory.getObject()));		
		} catch (IOException err) {
			err.printStackTrace();
			throw new ApplicationContextException("init env failed.", err);
		}
	}

}
