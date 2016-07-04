package br.com.fotosensores.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManager em;

	private JPAUtil() {
	}

	public static EntityManager getInstance(){
		if(em == null){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.DEFAULT.getValor());
			em = emf.createEntityManager();
		}
		return em;
	}

}
