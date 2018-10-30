package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import spittr.data.JdbcSpitterRepository;
import spittr.data.JdbcSpittleRepository;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;

@Configuration
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

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Bean
	public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
		return new JdbcSpitterRepository(jdbcTemplate);
	}

	@Bean
	public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate) {
		return new JdbcSpittleRepository(jdbcTemplate);
	}
}
