package onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ShowDept {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Dept dept = session.load(Dept.class, 1);
		System.out.println(dept.getName());

		for (Emp e : dept.getEmployees()) {
			System.out.println(e.getName());
		}
		session.close();
		sf.close();
	}

}
