package hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Author;
	
public class UpdateAuthor {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure(); // hibernate.cfg.xml
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Author a = session.get(Author.class,2);  // Persistent 
        a.setEmail("liberty@gmail.com");
        System.out.println("Changed Entity");
		trans.commit();
		System.out.println("Commited");
		session.close();
		sf.close();
	}

}
