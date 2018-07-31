package com.musala.company.jpa.hibernate.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DefaultConnection {
	
	private static DefaultConnection connectionFactory = null;
	
	protected static EntityManagerFactory emf;
    protected static EntityManager em;
    
	
	public static void init() {
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }
	
	public static EntityManager getEntityManager () {
		if(em == null) {
			init();
		}
		return em;
	}
	 
	  public static DefaultConnection getInstance () {
	        if (connectionFactory == null){
	            connectionFactory = new DefaultConnection();
	        }
	        return connectionFactory;
	    }

}
