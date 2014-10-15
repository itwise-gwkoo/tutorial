package demo;

import static org.junit.Assert.*;

import org.junit.Test;
















import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import demo.config.ApplicationContextConfig;
import demo.config.InitEnvironmentConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
@ContextConfiguration(classes = {ApplicationContextConfig.class}, initializers = InitEnvironmentConfig.class)
public class DemoTest {
	
	@Autowired
	private DataSource dataSource;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Connection connection;

	private EmbeddedDatabase database;
	
	
//	Dumy dumy = MockFactory.on(Dumy.class).create(entityManager);
	
	@Before
	public void setUp(){
		
		assertThat(0,is(0));

//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("test-data.sql").build();
		
//		logger.info("Starting in-memory HSQL Database for unit tests");
//		try {
//			Class.forName("org.hsqldb.jdbcDriver");
//			connection = DriverManager.getConnection("jdbc:hsqldb.mem:unit-test-jpa", "sa", "");
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
	@Test
	public void testTmp() throws Exception{
//		Dumy dumy = service.update(dumy);
	}
	
}
