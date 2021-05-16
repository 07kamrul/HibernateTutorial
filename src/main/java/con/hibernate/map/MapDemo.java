package con.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

//		Creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?");

//		Creating answer
		Answer a1 = new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("Java is programming language");
		a1.setQuestion(q1);
		q1.setAnswer(a1);

//		Session
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(q1);
		s.save(a1);
		tx.commit();

//		Fetching....
		Question newQ = (Question) s.get(Question.class, 1212);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());

		s.close();
		factory.close();

	}

}
