package run;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sun.xml.bind.v2.runtime.Name;

import entity.User;

public class JPA02CRUD {
	
	public static void create(EntityManager em) {
		User user = new User();
		user.setAge(25);
		user.setName("name1");
		em.persist(user);
	}
	public static void insert(EntityManager em, String name, int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		em.persist(user);
	}
	public static void allSelect(EntityManager em) {
		
		TypedQuery<User> typedQuery = em.createQuery("select u from User u", User.class);
		List<User> allMembers = typedQuery.getResultList();
		System.out.println(allMembers);
		
	}
//		public static void select(EntityManager em, String name) {
//		TypedQuery<User> typedQuery = em.createQuery("select u from User u where u.name = " + name, User.class);
//		List<User> allMembers = typedQuery.getResultList();
//		System.out.println(allMembers);
//		
//	}
	public static void update(EntityManager em) {
		User user2 = em.find(User.class, 1L);
		user2.setName("zzzz");
		user2.setAge(37);
	}
	public static void delete(EntityManager em) {
		
		User user2 = em.find(User.class, 2L);
		em.remove(user2);
				
	}
}
