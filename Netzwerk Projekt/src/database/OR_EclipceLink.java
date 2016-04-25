package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public final  class OR_EclipceLink {
	private static final String PERSISTENCE_UNIT_NAME="Kloud";
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	public OR_EclipceLink() {
		this.factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.entityManager=factory.createEntityManager();
	}
	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
	public List query( String queryst){
		Query query=entityManager.createQuery(queryst);
		List<Object> result=query.getResultList();
		return result;
	}
	public boolean insert(String toinsert) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		
	}
}
