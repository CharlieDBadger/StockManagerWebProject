package tools;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil { 
//  private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
//
//  private static EntityManagerFactory buildEntityManagerFactory(){
//      return Persistence.createEntityManagerFactory("hibernateOracle");
//  }
//
//  public static EntityManager getEntityManager() { 
//      return entityManagerFactory.createEntityManager();
//  }
  
  public static EntityManager getEM (String persistenceUnit) {
  	EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
  	EntityManager em = emf.createEntityManager(); 
  	
  	return em;
  }
}