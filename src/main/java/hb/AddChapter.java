package hb;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Book;
import entity.Chapter;
import entity.ChapterId;

public class AddChapter {

	public static void main(String[] args) {

		Configuration c = new Configuration().configure(); // hibernate.cfg.xml
		SessionFactory sf = c.buildSessionFactory();
		Session session = sf.openSession();
		Scanner s = new Scanner(System.in);

		while (true) {

			System.out.print("Enter bookid  [enter 0 to stop] : ");
			int bookid = s.nextInt();
			if (bookid == 0)
				break;
			System.out.print("Enter chapter number  : ");
			int chapterno = s.nextInt();

			s.nextLine(); // throw pending enter key from buffer
			String title = s.nextLine();

			ChapterId id = new ChapterId();
			id.setBookId(bookid);
			id.setChapterNo(chapterno);

			Chapter chapter = new Chapter();
			chapter.setTitle(title);
			chapter.setId(id);

			Transaction trans = session.beginTransaction();
			session.save(chapter); // Insert row into table
			trans.commit();

		}

		session.close();
		sf.close();
	}

}
