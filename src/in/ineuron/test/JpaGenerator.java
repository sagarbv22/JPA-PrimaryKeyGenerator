package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class JpaGenerator {

	public static void main(String[] args) throws IOException {

		Session session = null;
		boolean flag = false;
		Integer row = 0;
		Transaction transaction = null;
		Employee employee = null;

		try {

			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				employee = new Employee();
				employee.setEname("Punith");
				employee.setEcompany("Godrej");
				employee.setEcity("Blr");

				row = (Integer) session.save(employee);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			if (flag) {
				transaction.commit();
				System.out.println("Seccess");
			} else {
				transaction.rollback();
				System.out.println("Failed");
			}

		}

	}

}
