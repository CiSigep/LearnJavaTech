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
		List<TestLinkedOther> tlot = new ArrayList<TestLinkedOther>();
		tlot.add(new TestLinkedOther());
		tlot.add(new TestLinkedOther());
		
		tlot.get(0).setValue("One Other");
		tlot.get(1).setValue("Two Other");
		
		tlm.get(0).setVal("Hi");
		tlm.get(1).setVal("Hello");
		
		for(TestLinkedMany tl : tlm)
			tl.setTlj(tlj);
		
		tlj.setTlm(tlm);
		tlj.setTlot(tlot);
		
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
			
			for(TestLinkedOther tloth : tl.getTlj().getTlot())
				System.out.println(tloth.getValue());
		}
		
		s.close();
		System.out.println("Done");
		
	}
	

}
