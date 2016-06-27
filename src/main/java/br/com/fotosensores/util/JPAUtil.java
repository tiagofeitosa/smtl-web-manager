package br.com.fotosensores.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	private JPAUtil() {
		this.emf = Persistence.createEntityManagerFactory(Constants.DEFAULT.getValor());
		this.em = emf.createEntityManager();
	}

	public static EntityManager getEntityManager() {
		new JPAUtil();
		return em;
	}

	public static void close() {
		em.close();
		emf.close();
	}

}
