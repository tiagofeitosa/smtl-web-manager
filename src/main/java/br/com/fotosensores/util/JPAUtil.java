package br.com.fotosensores.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {


	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("default");
			entityManager = emf.createEntityManager();
		} catch (Exception e){
			e.printStackTrace();
		}
//		} finally {
//			emf.close();
//		}
		return entityManager;
	}
}
