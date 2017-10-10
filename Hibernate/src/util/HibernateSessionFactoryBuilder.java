package util;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateSessionFactoryBuilder {
	
	private static SessionFactory sf = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		
		try{
			Configuration c = new Configuration();
			c.configure("hibernate.cfg.xml");
			return c.buildSessionFactory();
		}
		catch(Throwable t){
			System.out.println("SessionFactory creation failed.");
			throw new ExceptionInInitializerError(t);
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sf;
	}

}
