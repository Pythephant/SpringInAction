package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import spittr.Spitter;

public class JdbcSpitterRepository implements SpitterRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSpitterRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Spitter save(Spitter spitter) {

		if (spitter.getId() == null) {
			long spitterId = insertSpitterAndReturnId(spitter);
			spitter.setId(spitterId);

		} else {
			jdbcTemplate.update(
					"update spitter set username = ?, password = ?, firstname = ?,lastname = ? where id = ?",
					spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(), spitter.getLastName(),
					spitter.getId());
		}

		return spitter;
	}

	private long insertSpitterAndReturnId(Spitter spitter) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("spitter");
		jdbcInsert.setGeneratedKeyName("id");
		Map<String, Object> args = new HashMap<>();
		args.put("username", spitter.getUsername());
		args.put("password", spitter.getPassword());
		args.put("firstname", spitter.getFirstName());
		args.put("lastname", spitter.getLastName());
		long spitterId = jdbcInsert.executeAndReturnKey(args).longValue();
		return spitterId;
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"select id, username, password, firstname, lastname from spitter where username = ?",
				new SpitterRowMapper(),username);
	}

	private static final class SpitterRowMapper implements RowMapper<Spitter> {

		@Override
		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String firstName = rs.getString("firstname");
			String lastName = rs.getString("lastname");
			return new Spitter(id, username, password, firstName, lastName);
		}

	}

}
