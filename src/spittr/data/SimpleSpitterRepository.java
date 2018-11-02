// package spittr.data;
//
// import java.util.HashMap;
//
// import org.springframework.stereotype.Repository;
//
// import spittr.domain.Spitter;
//
//// @Repository
// public class SimpleSpitterRepository implements SpitterRepository {
//
// private HashMap<String, Spitter> users = new HashMap<>();
//
// @Override
// public Spitter save(Spitter spitter) {
// users.put(spitter.getUsername(), spitter);
// return spitter;
// }
//
// @Override
// public Spitter findByUsername(String username) {
// return users.get(username);
// }
//
// }
