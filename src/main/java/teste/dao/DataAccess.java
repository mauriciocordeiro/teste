package teste.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import teste.config.HibernateUtil;


public abstract class DataAccess<T> implements IDataAccess<T> {

	synchronized public Integer create(T object) {
		Session session = HibernateUtil.getSession();
        return create(object, session);
	}
	synchronized public Integer create(T object, Session session) {
        session.beginTransaction();
        
        Integer id = (Integer) session.save(object);
                
        session.getTransaction().commit();
//        HibernateUtil.shutdown();
        
        return id;
	}
	
	synchronized public T retrieve(Class<T> type, Integer id) {
		Session session = HibernateUtil.getSession();      
        return retrieve(type, id, session);
	}	
	synchronized public T retrieve(Class<T> type, Integer id, Session session) {
		session.beginTransaction();
		
        T object = session.load(type, (Serializable) id);
        
        session.getTransaction().commit();
//        HibernateUtil.shutdown();
        
        return object;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	synchronized public List<T> retrieveAll(Class<T> type) {
		Session session = HibernateUtil.getSession();
        return retrieveAll(type, session);
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	synchronized public List<T> retrieveAll(Class<T> type, Session session) {
        session.beginTransaction();
                
		List<T> list = (List<T>) session.createCriteria(type).list();
        
        session.getTransaction().commit();
//        HibernateUtil.shutdown();
        
        return list;
	}
	
	synchronized public void update(T object) {
		Session session = HibernateUtil.getSession();
        update(object, session);
	}	
	synchronized public void update(T object, Session session) {
        session.beginTransaction();
        
        session.update(object);
                
        session.getTransaction().commit();
//        HibernateUtil.shutdown();
	}
	
	synchronized public void delete(T object) {
		Session session = HibernateUtil.getSession();
        session.beginTransaction();
        
        session.delete(object);
                
        session.getTransaction().commit();
//        HibernateUtil.shutdown();
	}
	

}
