package onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
	
public class AddDept {

	public static void main(String[] args) {
		Dept d = new Dept();
		d.setName("HR");
		
		Emp e = new Emp();
		e.setName("Mr. Gavin");
		e.setDept(d);
		
		Emp e2 = new Emp();
		e2.setName("Mr. Jhonson");
		e2.setDept(d);
		
		Configuration c = new Configuration().configure(); // hibernate.cfg.xml
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(d);  // Insert row into table 
		session.save(e);  // Insert row into table
		session.save(e2);  // Insert row into table
		trans.commit();
		session.close();
		sf.close();
	}

}
