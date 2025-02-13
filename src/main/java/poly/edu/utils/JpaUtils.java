package poly.edu.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static EntityManagerFactory factory;
	static public EntityManager getEntityManager() {
		if (factory==null||!factory.isOpen() ) {
			factory=Persistence.createEntityManagerFactory("AssignmentJava4");
		}
		return factory.createEntityManager();
		
	}
	static public void shutDown() {
		if (factory!=null&&factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
	public static void main(String[] args) {
		getEntityManager();
	}
}