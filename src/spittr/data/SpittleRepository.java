package spittr.data;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spittr.domain.Spittle;

public interface SpittleRepository extends JpaRepository<Spittle, Long> {
	@Query(value = "select * from Spittle", nativeQuery = true)
	public List<Spittle> findSpittles();

	@Cacheable(value = "spittleCache", condition = "#root.args[0]%5==0")
	@Query(value = "select * from Spittle where id = ?1", nativeQuery = true)
	public Spittle findOne(long id);
}
