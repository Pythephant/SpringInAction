package spittr.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.domain.Spittle;

public interface SpittleRepository extends JpaRepository<Spittle, Long> {
	public List<Spittle> findSpittles(long max, int count);

	public Spittle findOne(long id);
}
