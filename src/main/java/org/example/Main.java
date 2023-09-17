package org.example;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //등록
            /*
            //비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");
            System.out.println("=== BEFORE ===");
            //영속
            em.persist(member);
            System.out.println("=== AFTER ===");*/

            //Member findMember1 = em.find(Member.class, 101L);
            //Member findMember2 = em.find(Member.class, 101L);

            //System.out.println("findMember.id = " + findMember2.getId());
            //System.out.println("findMember.name = " + findMember2.getName());
            //System.out.println("result = " + (findMember1 == findMember2)); //동일성 비교 true

            /* 수정
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
            findMember.setName("HelloJPA");
            */

            //삭제 em.remove(findMember);

            /* 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    //.setFirstResult(5)
                    //.setMaxResults(8)
                    .getResultList();


            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
            */

            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);*/

            /*Member member = em.find(Member.class, 150l);
            member.setName("ZZZZZ");*/

            /*Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();*/

            //Member member = em.find(Member.class, 150l);
            //member.setName("AAAAA");


            //em.detach(member);
            //em.clear();
            //em.close();

            //Member member2 = em.find(Member.class, 150l);

            //System.out.println(" ================= ");

            /*Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);*/

            /*Member member = new Member();
            member.setUsername("user1");
            member.setCreateBy("kim");
            member.setCreateDate(LocalDateTime.now());

            em.persist(member);

            em.flush();
            em.clear();*/

            /*Item item = em.find(Item.class, movie.getId());
            System.out.println("item = " + item);*/

            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); //Proxy
            Hibernate.initialize(refMember);// 강제 초기화
            //refMember.getUsername(); //강제 초기화
            //System.out.println("isLoad = " + emf.getPersistenceUnitUtil().isLoaded(refMember));


            //em.detach(refMember);
            //em.close();

            //refMember.getUsername();
            //System.out.println("refMember.getUsername() = " + refMember.getUsername());
            
            //Member findMember = em.getReference(Member.class, member1.getId());
            //System.out.println("reference.getClass() = " + findMember.getClass()); //Member

            //System.out.println("(refMember == reference) = " + (refMember == findMember));

            //Member findMember = em.getReference(Member.class, member.getId());
            //Member findMember = em.find(Member.class, member.getId());
            //System.out.println("before findMember.getClass() = " + findMember.getClass());
            //System.out.println("findMember.id = " + findMember.getId());
            //System.out.println("findMember.username = " + findMember.getUsername());
            //System.out.println("after findMember.getClass() = " + findMember.getClass());

            //Member member = em.find(Member.class,1L);
            //printMemberAndTeam(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();

    }

    /*private static void logic(Member m1,Member m2) {
        System.out.println("m1 == m2 " + (m1 instanceof Member));
        System.out.println("m1 == m2 " + (m2 instanceof Member));
    }*/
}