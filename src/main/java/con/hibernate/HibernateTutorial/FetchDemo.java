package con.hibernate.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// Get , Load
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

//		Get-Student:101 by get
		System.out.println("Get Student by id");
		Student student = (Student) session.get(Student.class, 101);

		System.out.println(student);

		Address ad = (Address) session.get(Address.class, 1);
		System.out.println(ad.getStreet() + " : " + ad.getCity());

		Address ad1 = (Address) session.get(Address.class, 1);
		System.out.println(ad1.getStreet() + " : " + ad1.getCity());

//		Get-Student:101 by load
		System.out.println("Load Student by id");
		Student student1 = (Student) session.load(Student.class, 101);
		System.out.println(student1.getName());
		session.close();
		factory.close();
	}

}
