package mapping.test;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step04.entity.Member;
import step04.entity.Team;

public class Step04Test {

	static void logic(EntityManager em) {
		// team vs member - 외래키가 걸려있기 때문에 team 생성 우선
		// team vs member??? 
		Team teamA = new Team();
		teamA.setName("TeamA");
		em.persist(teamA);
		
		Member member1 = new Member();
		member1.setName("coffee");
		member1.setAge(27);
		member1.setTeam(teamA);
		em.persist(member1);
		
		teamA.getMembers().add(member1);
		
		Member member2 = new Member();
		member2.setName("coffee2");
		member2.setAge(28);
		member2.setTeam(teamA);
		em.persist(member2);
		
		teamA.getMembers().add(member2);
		
		em.flush();
		em.clear();
		
		Member findMember = em.find(Member.class, member1.getId());
		System.out.println("멤버 정보 : " + findMember.getName());
		
//		Team findTeam = findMember.getTeam();
//		System.out.println("팀 정보 : " + findTeam);
		
		
		
//		Member member01 = em.find(Member.class, member1.getId());
//		System.out.println(member01);
//		
//		Team team01 = em.find(Team.class, teamA.getId());
//		System.out.println(team01);
//		System.out.println(team01.getMembers());
//		
//		
//		List<Member> members = new ArrayList<Member>();
//		Member member3 = new Member();
//		member3.setName("coffee3");
//		member3.setAge(29);
//		member3.setTeam(teamB);
//		members.add(member3);
//		
//		team01.setMembers(members);
//		em.persist(team01);
//		System.out.println(team01.getMembers());

		
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
