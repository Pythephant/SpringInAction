// package spittr.data;
//
// import java.io.Serializable;
//
// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.criterion.Restrictions;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.transaction.annotation.Transactional;
//
// import spittr.domain.Spitter;
//
// @Transactional
// public class HibernateSpitterRepository implements SpitterRepository {
// private SessionFactory sessionFactory;
//
// @Autowired
// public HibernateSpitterRepository(SessionFactory sessionFactory) {
// this.sessionFactory = sessionFactory;
// }
//
// private Session currentSession() {
// return sessionFactory.getCurrentSession();
// }
//
// @Override
// public Spitter save(Spitter spitter) {
// if (spitter.getId() == null) {
// Serializable id = currentSession().save(spitter);
// spitter.setId((Long) id);
// } else {
// currentSession().update(spitter);
// }
// return spitter;
// }
//
// @Override
// public Spitter findByUsername(String username) {
// return (Spitter)
// currentSession().createCriteria(Spitter.class).add(Restrictions.eq("username",
// username))
// .list().get(0);
// }
//
// }
