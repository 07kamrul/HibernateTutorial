package con.hibernate.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student = new Student();
		student.setId(102);
		student.setName("Hasan");
		student.setCity("Dhaka");

		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("3 Months");

		student.setCertificate(certificate);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(student);
		tx.commit();
		session.close();
		factory.close();
		System.out.println(student);

		factory.close();
	}

}
