//package spittr.data;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import spittr.domain.Spittle;
//
//public class JdbcSpittleRepository implements SpittleRepository {
//	private JdbcTemplate jdbcTemplate;
//
//	@Autowired
//	public JdbcSpittleRepository(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public List<Spittle> findSpittles(long max, int count) {
//		return jdbcTemplate.query("select * from Spittle", new SpittleRowMapper());
//	}
//
//	@Override
//	public Spittle findOne(long id) {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.queryForObject("select * from Spittle where id = ?", new SpittleRowMapper(), id);
//	}
//
//	private static final class SpittleRowMapper implements RowMapper<Spittle> {
//
//		@Override
//		public Spittle mapRow(ResultSet rs, int arg1) throws SQLException {
//			// TODO Auto-generated method stub
//			return new Spittle(rs.getLong("id"), rs.getString("message"), rs.getTimestamp("spitime"),
//					rs.getDouble("latitude"), rs.getDouble("longitude"));
//		}
//
//	}
//
//}
