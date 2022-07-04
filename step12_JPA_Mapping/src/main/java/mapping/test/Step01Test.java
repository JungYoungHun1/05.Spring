package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step01.entity.Member;
import step01.entity.Team;

public class Step01Test {

	static void logic(EntityManager em) {
		// team vs member - 외래키가 걸려있기 때문에 team 생성 우선
	Team team = new Team();
	team.setName("TeamA");
	em.persist(team);
		
	Member member1 = new Member();
	member1.setName("gloryJeong");
	member1.setAge(26);
	member1.setTeamId(1L);
	em.persist(member1);
		
		
	}
	
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step12_JPA_Mapping");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			logic(em);
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}

}
