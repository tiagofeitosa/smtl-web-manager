package br.com.fotosensores.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fotosensores.model.Service;
import br.com.fotosensores.util.JPAUtil;

public class ServiceDAO extends GenericDao<Service> {
	
	private EntityManager manager;
	
	public List<Service> listAllServices() {

		manager = JPAUtil.getInstance();
		manager.getTransaction().begin();
		Query query = manager.createNativeQuery("select * from service", Service.class);
		List<Service> services = query.getResultList();
		manager.getTransaction().commit();
		
		return services;
		
	}
	
	public Service findServiceById(Long id) {
		
		manager = JPAUtil.getInstance();
		manager.getTransaction().begin();
		Service service = (Service) manager.createQuery("SELECT s FROM Service s WHERE s.id=:id").setParameter("id", id)
				.getSingleResult();
		manager.getTransaction().commit();

		return service;
		
	}
}
