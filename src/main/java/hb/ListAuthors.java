package hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Author;
	
public class ListAuthors {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		List<Author> authors = session.createQuery("from Author").list();
        for(Author author : authors) {
            System.out.println( author.getName());
        }
		session.close();
		sf.close();
	}

}
