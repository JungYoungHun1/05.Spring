package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.User;

public class JPAFinalTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step11_JPA_Pratice");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = new User();
		JPA02CRUD crud = new JPA02CRUD();
//		crud.create(em);
//		crud.insert(em,"string", 50);
//		crud.allSelect(em);
//		crud.select(em, "string");
		
//		crud.update(em);
		crud.delete(em);
		
		tx.commit();
	}

}
