package hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Author2;
	
public class AddAuthor2 {

	public static void main(String[] args) {
		Author2 author = new Author2();
		author.setAuid(3);
		author.setName("Gavin King");
		author.setEmail("king@gmail.com");

		Configuration c = new Configuration().configure();
		c.addAnnotatedClass(entity.Author2.class);
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(author);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
