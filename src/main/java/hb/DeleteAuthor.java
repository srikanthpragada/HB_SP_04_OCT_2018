package hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Author;
	
public class DeleteAuthor {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure(); // hibernate.cfg.xml
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Author a = session.get(Author.class,3);  // Persistent state 
		session.remove(a); // Removed state
		trans.commit();
		session.close();
		sf.close();
	}

}
