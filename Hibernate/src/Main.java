import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.TestLinkedMany;
import model.TestLinkedObject;
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
		
		s.saveOrUpdate(to);
		
		TestLinkedObject tlo = new TestLinkedObject();
		tlo.setValue("I have a value");
		to.setTlo(tlo);
		
		List<TestLinkedMany> tlm = new ArrayList<TestLinkedMany>();
		tlm.add(new TestLinkedMany());
		tlm.add(new TestLinkedMany());
		tlm.get(0).setVal("Hi");
		tlm.get(1).setVal("Hello");
		to.setMany(tlm);
		
		s.saveOrUpdate(to);
		
		s.flush();
		t.commit();
		s.close();
		
		s = sf.openSession();
		t = s.beginTransaction();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		
		CriteriaQuery<TestObject> cq = cb.createQuery(TestObject.class);
		Root<TestObject> r = cq.from(TestObject.class);
		cq.where(cb.equal(r.get("id"), 1));
		
		to = s.createQuery(cq).getSingleResult();
		
		System.out.println(to.getTlo().getValue());
		for(TestLinkedMany tl : to.getMany())
			System.out.println(tl.getVal());
		
		s.close();
		System.out.println("Done");
		
	}
	

}
