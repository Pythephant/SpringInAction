package spittr.data;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;

import spittr.domain.Spittle;

public interface SpittleRepository extends JpaRepository<Spittle, Long> {
	@Query(value = "select * from Spittle order by spitime desc", nativeQuery = true)
//	@PostFilter("!isAuthenticated() || filterObject.username == principal.username")
	public List<Spittle> findSpittles();

	@Cacheable(value = "spittleCache")
	@Query(value = "select * from Spittle where id = ?1", nativeQuery = true)
	public Spittle findOne(long id);

	@CachePut(value = "spittleCache", key = "#result.id")
	public Spittle save(Spittle spittle);
}
