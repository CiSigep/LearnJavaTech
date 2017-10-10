import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.TestObject;
import util.HibernateSessionFactoryBuilder;

public class Main {
	
	public static void main(String[] args){
		SessionFactory sf = HibernateSessionFactoryBuilder.getSessionFactory();
		
		
		Session s = sf.openSession();
		Transaction t = s.getTransaction();
		t.begin();
		
		TestObject to = new TestObject();
		to.setTest("I am a test object");
		
		s.save(to);
		
		s.flush();
		t.commit();
		s.close();
		
		System.out.println("Done");
		
	}
	

}
