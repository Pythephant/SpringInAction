package spittr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.domain.Spitter;
import spittr.domain.Spittle;

@Component
public class SpittrServiceImpl implements SpittrService {

	@Autowired
	private SpittleRepository spittleRepo;

	@Autowired
	private SpitterRepository spitterRepo;

	@Override
	public Spittle getSpittle(Long id) {
		return spittleRepo.findOne(id);
	}

	@Override
	public Spitter getSpitterByUsername(String username) {
		return spitterRepo.findByUsername(username);
	}

}
