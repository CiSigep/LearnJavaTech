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

import model.TestLinkedJunction;
import model.TestLinkedMany;
import model.TestLinkedObject;
import model.TestLinkedOther;
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
		
		TestLinkedJunction tlj = new TestLinkedJunction();
		TestLinkedOther tlot = new TestLinkedOther();
		
		tlot.setVal("One Other");
		tlot.setTlj(new ArrayList<TestLinkedJunction>());
		tlot.getTlj().add(tlj);
		tlj.setTlot(tlot);
		tlm.get(0).setTlj(new ArrayList<TestLinkedJunction>());
		tlj.setTlm(tlm.get(0));
		tlm.get(0).getTlj().add(tlj);
		tlm.get(0).setVal("Hi");
		
		tlot = new TestLinkedOther();
		tlj = new TestLinkedJunction();
		
		
		tlot.setVal("Two Other");
		tlot.setTlj(new ArrayList<TestLinkedJunction>());
		tlot.getTlj().add(tlj);
		tlj.setTlot(tlot);
		tlm.get(1).setTlj(new ArrayList<TestLinkedJunction>());
		tlj.setTlm(tlm.get(0));
		tlm.get(1).getTlj().add(tlj);
		tlm.get(1).getTlj().add(tlm.get(0).getTlj().get(0));
		tlm.get(0).getTlj().add(tlj);
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
		for(TestLinkedMany tl : to.getMany()){
			System.out.println(tl.getVal());
			
			for(TestLinkedJunction tlju : tl.getTlj())
				System.out.println(tlju.getTlot().getVal());
		}
		
		s.close();
		System.out.println("Done");
		
	}
	

}
