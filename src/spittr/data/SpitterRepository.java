package spittr.data;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.domain.Spitter;

public interface SpitterRepository extends JpaRepository<Spitter, Long> {
	public Spitter save(Spitter spitter);

	public Spitter findByUsername(String username);
}
