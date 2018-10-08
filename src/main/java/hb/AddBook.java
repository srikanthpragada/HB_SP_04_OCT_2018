package hb;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Book;

public class AddBook {

	public static void main(String[] args) {

		Configuration c = new Configuration().configure(); // hibernate.cfg.xml
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Scanner s = new Scanner(System.in);

		while (true) {

			System.out.print("Enter title [enter to stop] : ");
			String title = s.nextLine();
			if (title.length() == 0)
				break;

			System.out.print("Enter price : ");
			int price = s.nextInt();
            // read and throw new line from keyboard buffer
			s.nextLine(); 
			Book book = new Book();
			book.setTitle(title);
			book.setPrice(price);

			Transaction trans = session.beginTransaction();
			session.save(book); // Insert row into table
			trans.commit();

		}

		session.close();
		sf.close();
	}

}
