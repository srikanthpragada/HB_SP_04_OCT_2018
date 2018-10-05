package hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Author;
	
public class AddAuthor {

	public static void main(String[] args) {
		Author author = new Author();
		author.setAuid(2);
		author.setName("Jessy Liberty");
		author.setEmail("liberty@gmail.com");

		Configuration c = new Configuration().configure(); // hibernate.cfg.xml
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(author);  // Insert row into table 
		trans.commit();
		session.close();
		sf.close();
	}

}
