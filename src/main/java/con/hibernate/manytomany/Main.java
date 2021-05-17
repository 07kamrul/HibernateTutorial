package con.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		emp1.setEmpId(34);
		emp1.setEmpName("Kamrul");

		emp2.setEmpId(43);
		emp2.setEmpName("Hasan");

		Project pro1 = new Project();
		Project pro2 = new Project();

		pro1.setProjectId(12121);
		pro1.setProjectName("Evaly");

		pro2.setProjectId(21212);
		pro2.setProjectName("E-orange");

		List<Employee> empList = new ArrayList<Employee>();
		List<Project> proList = new ArrayList<Project>();

		empList.add(emp1);
		empList.add(emp2);

		proList.add(pro1);
		proList.add(pro2);

		emp1.setProjects(proList);
		pro1.setEmployees(empList);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(emp1);
		session.save(emp2);
		session.save(pro1);
		session.save(pro2);

		tx.commit();

		factory.close();
	}

}
