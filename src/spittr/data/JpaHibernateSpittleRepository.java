//package spittr.data;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.transaction.annotation.Transactional;
//
//import spittr.domain.Spittle;
//
//@Transactional
//public class JpaHibernateSpittleRepository implements SpittleRepository {
//
//	@PersistenceContext
//	private EntityManager em;
//
//	@Override
//	public List<Spittle> findSpittles(long max, int count) {
//		// TODO Auto-generated method stub
//		return (List<Spittle>) em.createQuery("select s from Spittle s").getResultList();
//	}
//
//	@Override
//	public Spittle findOne(long id) {
//		// TODO Auto-generated method stub
//		return (Spittle) em.createQuery("select s from Spittle s where s.id = ?").setParameter(1, id).getSingleResult();
//	}
//
//}
