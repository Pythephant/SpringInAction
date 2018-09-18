package spittr.data;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class SimpleSpitterRepository implements SpitterRepository {

	private HashMap<String, Spitter> users = new HashMap<>();

	@Override
	public void save(Spitter spitter) {
		System.out.println(spitter);
		users.put(spitter.getUsername(), spitter);
	}

	@Override
	public Spitter findByUsername(String username) {
		return users.get(username);
	}

}
