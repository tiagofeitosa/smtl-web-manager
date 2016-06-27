package br.com.fotosensores.observer;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import br.com.fotosensores.model.Service;
import br.com.fotosensores.util.JPAUtil;

@ApplicationScoped
public class InitializationObserver {
	
	private EntityManager manager;
	private List<Service> list;

	@SuppressWarnings("unchecked")
	public InitializationObserver() {
		manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createNativeQuery("select * from service", Service.class);
		list = query.getResultList();
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void init(@Observes ServletContext context) {
	
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (Service service : list) {
					String[] cmd = {"/bin/bash","-c","echo foto123 | sudo -S " + service.getPath() + " start"};
				    try {
						Process pb = Runtime.getRuntime().exec(cmd);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});	
		t.start();
	}	
	
}
