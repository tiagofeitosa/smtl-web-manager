package br.com.fotosensores.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

public class GenericDao<T> {

	@Inject
	private EntityManager entity;

	public EntityManager getEntity() {
		
		return entity;
	}

	public Session getSession() {
		
		return entity.unwrap(Session.class);
	}

	public T save(T obj) {

		entity.persist(obj);

		return obj;
	}

	public T update(T obj) {

		entity.merge(obj);

		return obj;
	}	
	
	@SuppressWarnings("unchecked")
	public List<T> listAll() {

		String hql = "SELECT g FROM " + getGenericClass().getSimpleName() + " g";
		
		Query query = entity.createQuery(hql);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T findById(Long id) {

		String hql = "SELECT g FROM " + getGenericClass().getSimpleName() + " g WHERE id = " + id;
		
		Query query = entity.createQuery(hql);

		return (T) query.getSingleResult();
	}
	
	public void remove(Long id) {
		
		String hql = "DELETE FROM " + getGenericClass().getSimpleName() + " g WHERE g.id = :id";
        
		Query query = entity.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public Class<T> getGenericClass() {

		return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
}