package fr.formation.inti.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.utils.HibernateUtils;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction tx = session.getTransaction();
		tx.begin();
		
		System.out.println("Find Employee");
		Employee emp = session.find(Employee.class, 3);
		System.out.println(emp);
		
		tx.commit();
		
		session.close();
		factory.close();

	}
}
