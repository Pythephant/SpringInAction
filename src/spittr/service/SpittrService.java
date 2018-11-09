package spittr.service;

import spittr.domain.Spitter;
import spittr.domain.Spittle;

public interface SpittrService {
	public Spittle getSpittle(Long id);

	public Spitter getSpitterByUsername(String username);
}
