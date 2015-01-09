package com.dao;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Entity;
/**
 * CRUD operations methods are defined  here .
 * @author Vinay Singh Rawat
 * 
 */
public class BackEndDao implements IGenericBackEndDao<Entity> {

	// private Transaction transaction=null;
	private SessionFactory sessionFactory = null;
	private Session session = null;
	private Transaction transaction = null;
	public BackEndDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> getEntityList(Class<? extends Entity> clazz)
			throws HibernateException, Exception {

		List<Entity> entities = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(clazz);
			entities = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return entities;
	}

	@Override
	public boolean addEntity(Entity entity) throws Exception {
		try {
			session = sessionFactory.openSession();
			transaction = session.getTransaction();
			session.beginTransaction();
			session.save(entity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteEntity(long id, Class<? extends Entity> clazz)
			throws Exception {
		try {
			session = sessionFactory.openSession();
			transaction = session.getTransaction();
			session.beginTransaction();
			Object o = session.load(clazz, new Long(id));
			session.delete(o);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Entity getEntity(long id, Class<? extends Entity> clazz)
			throws Exception {
		try {
			session = sessionFactory.openSession();
			Entity entity = (Entity) session.get(clazz, new Long(id));
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateEntity(Class<? extends Entity> clazz, Entity entity)
			throws Exception {
		try {
			session = sessionFactory.openSession();
			transaction = session.getTransaction();
			session.beginTransaction();
			Entity entity1 = (Entity) session.load(clazz, entity.getId());
			BeanUtils.copyProperties(entity1, entity);
			session.update(entity1);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
