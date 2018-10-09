package onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Author;
	
public class ListEmp {

	public static void main(String[] args) {
		Configuration c = new Configuration().configure();
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		List<Emp> emps = session.createQuery("from Emp").list();
        for(Emp e : emps) {
            System.out.printf("%-20s  %s\n",e.getName(), e.getDept().getName());
        }
		session.close();
		sf.close();
	}

}
