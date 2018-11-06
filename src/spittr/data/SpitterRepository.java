package spittr.data;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import spittr.domain.Spitter;

public interface SpitterRepository extends JpaRepository<Spitter, Long> {

	@CachePut(value = "spittleCache", key = "#result.username")
	public Spitter save(Spitter spitter);

	@Cacheable(value = "spittleCache")
	@PreAuthorize("isAuthenticated() and #username == principal.username")
	public Spitter findByUsername(@Param("username") String username);
}
