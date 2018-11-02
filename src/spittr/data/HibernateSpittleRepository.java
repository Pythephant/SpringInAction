//package spittr.data;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.context.spi.CurrentSessionContext;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import spittr.domain.Spittle;
//
//@Transactional
//public class HibernateSpittleRepository implements SpittleRepository {
//
//	private SessionFactory sessionFactory;
//
//	@Autowired
//	public HibernateSpittleRepository(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//
//	private Session currentSession() {
//		return sessionFactory.getCurrentSession();
//	}
//
//	@Override
//	public List<Spittle> findSpittles(long max, int count) {
//
//		return (List<Spittle>) currentSession().createCriteria(Spittle.class).list();
//	}
//
//	@Override
//	public Spittle findOne(long id) {
//		return (Spittle) currentSession().createCriteria(Spittle.class).add(Restrictions.eq("id", id)).list().get(0);
//	}
//
//}
