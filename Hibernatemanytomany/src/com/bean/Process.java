package com.bean;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.dao.HibernateUtil;

public class Process {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Role role1 = new Role("Admin");
		Role role2 = new Role("Programmer");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role1);
		roles.add(role2);
		Employee employee = new Employee("Vinay", "Rawat", roles);
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			/***
			 * Queries will run: Hibernate: select max(EID) from EMPLOYEE
			 * Hibernate: select max(RID) from ROLE Hibernate: insert into
			 * EMPLOYEE (FIRSTNAME, LASTNAME, EID) values (?, ?, ?) Hibernate:
			 * insert into ROLE (ROLENAME, RID) values (?, ?) Hibernate: insert
			 * into ROLE (ROLENAME, RID) values (?, ?) Hibernate: insert into
			 * EMP_ROLE (emp_id, role_id) values (?, ?) Hibernate: insert into
			 * EMP_ROLE (emp_id, role_id) values (?, ?)
			 * ***/
			session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

}
