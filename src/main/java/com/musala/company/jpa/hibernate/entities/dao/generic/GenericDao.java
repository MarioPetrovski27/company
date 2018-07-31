package com.musala.company.jpa.hibernate.entities.dao.generic;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public T findByID(Class<T> clazz, ID id);

	public List<T> findAll(Class<T> clazz);

}