package spittr.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import spittr.domain.Spitter;

// @Transactional
// public class JpaHibernateSpitterRepository
// implements SpitterRepository
// {
//
// @PersistenceContext
// private EntityManager em;
//
// @Override
// public Spitter save(Spitter spitter) {
// em.persist(spitter);
// return spitter;
// }
//
// @Override
// public Spitter findByUsername(String username) {
//
// return (Spitter) em.createQuery("select s from Spitter s where s.username =
// ?").setParameter(1, username)
// .getSingleResult();
// }
//
// }
