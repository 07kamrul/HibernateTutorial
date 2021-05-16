package con.hibernate.HibernateTutorial;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started...");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
//		System.out.println(factory);
//		System.out.println(factory.isClosed());

		// Creating Student
		Student st = new Student();
		st.setId(101);
		st.setName("Kamrul");
		st.setCity("Dhaka");
		System.out.println(st);

		// Creating Address
		Address ad = new Address();
		ad.setStreet("Mirpur");
		ad.setCity("Dhaka");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.234);

//		Reading Image
		FileInputStream fis = new FileInputStream("src/main/resources/pp.jpeg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

//		Session session = factory.getCurrentSession();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done...");
	}
}
