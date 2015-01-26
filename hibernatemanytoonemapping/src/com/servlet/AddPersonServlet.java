package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.Address;
import com.bean.Person;
import com.dao.HibernateUtil;

/**
 * Servlet implementation class AddPersonServlet
 */
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = -1397627319584608501L;
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction transaction = null;

	@Override
	public void init() throws ServletException {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Getting persons and their address data from post request

		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String zipCode = request.getParameter("zipCode");
		// Making address object to saved into databases
		Address address = new Address(city, street, zipCode);

		String person_name1 = request.getParameter("person_name1");
		String person_name2 = request.getParameter("person_name2");
		String person_name3 = request.getParameter("person_name3");
		String person_name4 = request.getParameter("person_name4");
		// Making person objects to saved into databases
		Person person1 = new Person(person_name1, address);
		Person person2 = new Person(person_name2, address);
		Person person3 = new Person(person_name3, address);
		Person person4 = new Person(person_name4, address);
		// Persons list to save in one transaction
		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);

		try {
			/***
			 * Adding 4 person with same address into database this is called
			 * many to one relation, here many persons have same address.
			 **/
			addPesrons(persons);
			request.setAttribute("msg",
					"Persons addded successfuly along with their address");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * 
	 * @param List
	 *            <Person> persons
	 * @throws HibernateException
	 */
	public void addPesrons(List<Person> persons) throws HibernateException {
		try {
			session = sessionFactory.openSession();
			transaction = session.getTransaction();
			session.beginTransaction();
			for (Person person : persons) {
				session.save(person);
			}
			transaction.commit();
			/***
			 * Below are hibernate queries get executed for this eaxmple
			 * Hibernate: select max(PID) from PERSON Hibernate: select max(AID)
			 * from ADDRESS Hibernate: insert into ADDRESS (CITY, STREET,
			 * ZIPCODE, AID) values (?, ?, ?, ?) Hibernate: insert into PERSON
			 * (NAME, PERSON_ADDRESS, PID) values (?, ?, ?) Hibernate: insert
			 * into PERSON (NAME, PERSON_ADDRESS, PID) values (?, ?, ?)
			 * Hibernate: insert into PERSON (NAME, PERSON_ADDRESS, PID) values
			 * (?, ?, ?) Hibernate: insert into PERSON (NAME, PERSON_ADDRESS,
			 * PID) values (?, ?, ?)
			 * ***/
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
