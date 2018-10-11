package query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ListTitles {

	public static void main(String[] args) {
		Configuration c = new Configuration();
		c.configure("query/hibernate.cfg.xml");
		c.addResource("query/catalog.hbm.xml");
		Session session = c.buildSessionFactory().openSession();

		List<Title> titles = session.createQuery("from Title").list();
		for (Title t : titles) {
			System.out.println(t.getClass());
			System.out.printf("%-20s  %s\n", t.getTitle(), t.getSubject().getSubname());
		}
		session.close();
	}

}
