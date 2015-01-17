package com.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.bean.Entity;
/**
 * CRUD operations methods are declared here .
 * @author Vinay Singh Rawat
 * 
 * @param <T>
 */
public interface IGenericBackEndDao<T extends Entity> {
	/**
	 * @param entity
	 * @return boolean
	 * @throws Exception
	 */
	public boolean addEntity(T entity) throws Exception;
	
	/**
	 * @param entity
	 * @return boolean
	 * @throws Exception
	 */
	
	public boolean updateEntity(Class<? extends Entity> clazz,Entity entity) throws Exception;

	/**
	 * @param clazz
	 * @return T
	 * @throws Exception
	 */
	public T getEntity(long id, Class<? extends Entity> clazz) throws Exception;
	/**
	 * @param id
	 * @param clazz
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteEntity(long id, Class<? extends Entity > clazz) throws Exception;

	/**
	 * @param clazz
	 * @return List<T>
	 * @throws HibernateException
	 * @throws Exception
	 */
	
	public List<T> getEntityList(Class<? extends Entity> clazz) throws HibernateException,
			Exception;
	

}
