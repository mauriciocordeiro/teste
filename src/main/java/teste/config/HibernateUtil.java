package teste.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	 
	private static SessionFactory buildSessionFactory() {
	     
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("/teste/config/hibernate.cfg.xml").build();
	    Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
	    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
	        	
	    return sessionFactory;
	}	
	 
	public static SessionFactory getSessionFactory() {
	    if(sessionFactory == null || sessionFactory.isClosed()) 
	    	sessionFactory = buildSessionFactory();
	    
	    return sessionFactory;
	}
	
	public static Session getSession() {
		if(session == null || !session.isOpen())
			session =  getSessionFactory().openSession();
		
		return session;
	}
	
	public static StatelessSession openStatelessSession() {
		SessionFactory sessionFactory = getSessionFactory();
		
		return sessionFactory.openStatelessSession();
	}
	

	public static void shutdown() {
        getSessionFactory().close();
    }
}
