package spittr.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//import spittr.data.HibernateSpitterRepository;
//import spittr.data.HibernateSpittleRepository;
//import spittr.data.JdbcSpitterRepository;
//import spittr.data.JdbcSpittleRepository;
//import spittr.data.JpaHibernateSpitterRepository;
//import spittr.data.JpaHibernateSpittleRepository;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.domain.Spitter;
import spittr.domain.Spittle;

@Configuration
@EnableJpaRepositories("spittr.data")
public class DataConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/spittr");
		ds.setUsername("root");
		ds.setPassword("123456");
		return ds;
	}

	// JDBC way to operate the data access
	// @Bean
	// public JdbcTemplate jdbcTemplate(DataSource ds) {
	// return new JdbcTemplate(ds);
	// }

	// 2. START // The Hibernate Persistence configurations
	// @Bean
	// public LocalSessionFactoryBean sessionFactory(DataSource ds) {
	// LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	// // AnnotationSessionFactoryBean factoryBean = new
	// // AnnotationSessionFactoryBean();
	// factoryBean.setDataSource(ds);
	// // factoryBean.setAnnotatedPackages(new String[] { "spittr" });
	// factoryBean.setAnnotatedClasses(new Class<?>[] { Spitter.class, Spittle.class
	// });
	// Properties prop = new Properties();
	// prop.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
	// factoryBean.setHibernateProperties(prop);
	// return factoryBean;
	// }

	// @Bean
	// public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
	// return new JdbcSpitterRepository(jdbcTemplate);
	// }

	// @Bean
	// SpitterRepository SpitterRepository(SessionFactory sf) {
	// return new HibernateSpitterRepository(sf);
	// }

	// @Bean
	// public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate) {
	// SpittleRepository spittleRepository = new
	// JdbcSpittleRepository(jdbcTemplate);
	// return spittleRepository;
	// }
	//
	// @Bean
	// public SpittleRepository SpittleRepository(SessionFactory sf) {
	// return new HibernateSpittleRepository(sf);
	// }

	// @Bean
	// public HibernateTransactionManager transactionManager(SessionFactory sf) {
	// return new HibernateTransactionManager(sf);
	// }

	// END 2. Hibernate Configuration

	// START 3 .The JPA persistence configuration with low level(Hibernate)
	// @Bean
	// public PlatformTransactionManager
	// PlatformTransactionManager(EntityManagerFactory emf) {
	// return new JpaTransactionManager(emf);
	// }
	//
	// @Bean
	// public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource
	// dataSource,
	// JpaVendorAdapter jpaVendorAdapter) {
	// LocalContainerEntityManagerFactoryBean emf = new
	// LocalContainerEntityManagerFactoryBean();
	// emf.setDataSource(dataSource);
	// emf.setJpaVendorAdapter(jpaVendorAdapter);
	// emf.setPackagesToScan("spittr.domain");
	// return emf;
	// }
	//
	// @Bean
	// public JpaVendorAdapter jpaVendorAdapter() {
	// HibernateJpaVendorAdapter adaper = new HibernateJpaVendorAdapter();
	// adaper.setDatabasePlatform("MYSQL");
	// adaper.setShowSql(true);
	// adaper.setGenerateDdl(false);
	// adaper.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	//
	// return adaper;
	// }
	//
	// // configuration the bean to allow the @PersistenceUnit and
	// @PersistenceContext
	// @Bean
	// public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
	// return new PersistenceAnnotationBeanPostProcessor();
	// }
	//
	// @Bean
	// public SpitterRepository spitterRepository() {
	// return new JpaHibernateSpitterRepository();
	// }
	//
	// @Bean
	// public SpittleRepository spittleRepository() {
	// return new JpaHibernateSpittleRepository();
	// }

	@Bean
	public JpaTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setPackagesToScan("spittr.domain");
		return emf;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adaper = new HibernateJpaVendorAdapter();
		adaper.setDatabasePlatform("MYSQL");
		adaper.setShowSql(true);
		adaper.setGenerateDdl(false);
		adaper.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

		return adaper;
	}

	// configure the exception mapping to the Spring SQLException hierarchy
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
