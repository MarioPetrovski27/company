package com.musala.company.jpa.hibernate.entities.dao.generic.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.musala.company.exception.DataNotFoundException;
import com.musala.company.exception.DatabaseException;
import com.musala.company.jpa.hibernate.connection.DefaultConnection;
import com.musala.company.jpa.hibernate.entities.dao.generic.GenericDao;

public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	EntityManager entityManager;

	public void save(T entity) {
		EntityManager entityManager = this.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println(entity.getClass().getName() + " is saved!");
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage() + " Record isn`t saved!");
		} finally {
			entityManager.getTransaction().rollback();
		}
	}

	public void update(T entity) {
		EntityManager entityManager = this.getEntityManager();
		try {

			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println(entity.getClass().getName() + " is successfully updated!");
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage() + " Record isn`t updated!");
		} finally {
			entityManager.getTransaction().rollback();
		}
	}

	public void delete(T entity) {
		EntityManager entityManager = this.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
			entityManager.getTransaction().commit();
			System.out.println(entity.getClass().getName() + " is successfully deleted!");
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage() + " Record isn`t deleted!");
		} finally {
			entityManager.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public T findOne(Query query) {
		T t;
		t = (T) query.getSingleResult();
		return t;
	}

	public T findByID(Class<T> clazz, ID id) {
		EntityManager entityManager = this.getEntityManager();
		T t = null;
		try {
			t = entityManager.find(clazz, id);
			entityManager.refresh(t);
		} catch (IllegalArgumentException e) {
			throw new DataNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage() + " Database error.");
		} finally {
			entityManager.getTransaction().rollback();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> clazz) {
		EntityManager entityManager = this.getEntityManager();
		List<T> t = null;
		try {
			Query query = entityManager.createQuery("from " + clazz.getName());
			t = (List<T>) query.getResultList();
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage() + " Can`t get all objects");
		} finally {
			entityManager.getTransaction().rollback();
		}
		return t;
	}

	public EntityManager getEntityManager() {
		if (this.entityManager == null) {
			this.entityManager = DefaultConnection.getEntityManager();
		}
		return this.entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = DefaultConnection.getEntityManager();
	}

	public boolean findId(T entity) {

		return true;
	}
}